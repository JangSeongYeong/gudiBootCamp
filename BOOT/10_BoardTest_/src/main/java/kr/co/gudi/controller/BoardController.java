package kr.co.gudi.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.gudi.dto.BoardDTO;
import kr.co.gudi.service.BoardService;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	// 싱글톤 패턴 : 하나의 객체를 원본영역에 두고, 이것을 바라보도록 만든 구조(다수의 객체를 불필요하게 만들 필요가 없다.)
	// @Autowired BoardService service; // 필드 주입 -> 변수를 통해서 객체를 참조해 오기 때문에
	// 위의 필드 주입은 사용을 권고하고 있지 않는다.
	// 이유 1. final 을 붙여 불변성을 보장할 수 없다.
	// 이유 2. 객체간 순환 참조를 방지할 수 없다.
	// 순환 참조 : 서로가 서로를 보고 있으면서 상대의 변화가 생길때마다 나의 변화가 생기면, 무한으로 서로의 변화를 감지해야 한다. (내부적으로 무한루프)
	// 우리가 그동안 Contoller -> Service -> DAO 순으로 Autowiered 를 통해 참조하였다. 이런 단방향은 문제되지 않는다.
	// 하지만 Service 가 여러개이고, 이것들이 서로가 서로를 호출할 경우 문제가 발생할 수 있다.
	// 예) MainService 가 MemberService 를 Autowired 했는데, MainService 를 Autowired 한 경우
	// 이 경우 Autowired 를 사용하는 경우, 프로그램이 실제로 문제가 발생하는 상황(stack over flow)이 되서 순환참조를 알 수 있다.
	
	// 그래서 순수 자바를 사용해서 주입하면 컴파일 단계에서 순환 참조를 알아낼 수 있다. -> 실수의 조기 발견이 가능
	// 또는 Lombok 의 @RequiredArgsConstructor 를 대신 사용해도 된다. 
	
	// 생성자 주입
	private final BoardService service;
	
	public BoardController(BoardService service) { // 복수 서비스를 사용할떄는 매개변수에 추가
		this.service = service;
	}
	
	/* 2개를 받을 경우
	private final BoardService bbs_service;
	private final MemberService mem_service;
	
	public BoardController(BoardService bbs_service, MemberService mem_service) {
		this.bbs_service = bbs_service;
		this.mem_service = mem_service;
	}
	*/
	
	/* 2개 이상일 경우 @Autowired 를 붙여준다.
	@Autowired A a
	@Autowired B b
	@Autowired C c
	
	public BoardController(A a, B b, C c) {
		this.A = a;
		this.B = b;
		this.C = c;
	}
	*/
	
	@RequestMapping(value="/")
	public String home() {
		return  "login";
	}
	
	// 로그인 요청
	// redirect 는 response 객체 이므로 데이터를 실어 나를 수 없다.
	// 그래서 Model 에 데이터를 넣어서 보낼 수 없는 것이다.
	@PostMapping(value="/login")
	public String login(HttpSession session, Model model, RedirectAttributes rAttr, String id, String pw) {
		logger.info("로그인 요청 id : {}, pw : {}", id, pw);
		String page = "redirect:/";
		
		int cnt = service.login(id, pw);
		String msg = "아이디 또는 패스워드를 확인하세요!";
		if (cnt > 0) {
			page = page+"list";
			msg = "안녕하세요, "+id+"님";
			session.setAttribute("loginId", id);
		}
		// model.addAttribute("msg", msg);
		
		// session 에 데이터 저장 후, 사용 즉시 지운다.
		// 그래서 Flash
		rAttr.addFlashAttribute("msg", msg);
		
		return  page;
	}
	
	// 로그아웃
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, RedirectAttributes rAttr) {
		session.removeAttribute("loginId");
		rAttr.addFlashAttribute("msg", "로그아웃 되셨습니다.");
		
		return "redirect:/";
	}
	
	//리스트 불러오기
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, HttpSession session) {
		logger.info("list");
		String page = "login";
		
		
		String id = (String) session.getAttribute("loginId");
		if(id !=null) {
			page = "list";
			List<BoardDTO> list = service.list();
			logger.info("list size :"+list.size());
			model.addAttribute("list", list);
			model.addAttribute("loginBox", "<div>안녕하세요 "+id+" 님<a href='logout'>로그아웃</a></div>");
		}else {
			model.addAttribute("msg","로그인이 필요한 서비스 입니다.");
		}
		return page;
	}
	
	// 글쓰기 이동
	@GetMapping(value = "/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	// 글쓰기
	@PostMapping(value = "/write")
	public String write(HttpSession session, RedirectAttributes rAttr, 
			BoardDTO dto) {
		
		String page = "redirect:/list";
		String msg = "작성에 실패했습니다.";
		
		if(session.getAttribute("loginId") == null) {
			page = "redirect:/";
			msg = "로그인이 필요한 서비스 입니다.";
		} else {
			int idx = service.write(dto);
			page = "redirect:/detail?idx="+idx;
			msg= "";
		}
		rAttr.addFlashAttribute("msg", msg);
		
		return page;
	}
	
	// 상세보기
	@GetMapping(value = "/detail")
	public ModelAndView detail(String idx, HttpSession session) {
		logger.info("detail idx : "+idx);
		return service.detail(idx, session);
	}
	
}
