package kr.co.photo.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.photo.member.dto.MemberDTO;
import kr.co.photo.member.service.MemberService;

@Controller
public class MemberController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	// 에러 코드 관련 요청이 올 시
	@RequestMapping(value = "/error/404")
	public String notFound(Model model) {
		model.addAttribute("code","404");
		model.addAttribute("msg", "없는 페이지 또는 요청입니다.");
		return "error";
	}
	
	@RequestMapping(value = "/error/500")
	public String serverError(Model model) {
		model.addAttribute("code","500");
		model.addAttribute("msg", "서버 처리중 문제가 발생했습니다.");
		return "error";
	}
	
	
	@RequestMapping(value="/")
	public String home() {
		logger.info("main page in");
		return "login";
	}
	
	// 회원가입 이동
	@RequestMapping(value="/join.go")
	public String joinForm() {
		logger.info("joinForm in");
		return "joinForm";
	}
	
	// 회원가입
	@RequestMapping(value="/join.do")
	public String join(Model model, @RequestParam Map<String, String> param) {
		String page = "joinForm";
		String msg = "회원가입에 실패 했습니다.";
		logger.info("param : "+param);
		
		int row = service.join(param);
		logger.info("insert count : " +row);
		
		if(row==1) {
			page = "login";
			msg = "회원가입에 성공 했습니다.";
		}
		
		model.addAttribute("msg", msg);
		return page;
	}
	
	@RequestMapping(value="/login.do")
	public String login(Model model, HttpSession session, String id, String pw) {
		String page = "login";
		
		logger.info("id : {} / pw : {}", id, pw);
		MemberDTO info = service.login(id, pw);
		logger.info("loginInfo : "+info);
		if (info != null) {
			page = "redirect:/list";
			session.setAttribute("loginInfo", info);
		}else {
			model.addAttribute("msg", "아이디 또는 패스워드를 확인해주세요.");
		}
		
		return page;
	}
	
	@RequestMapping(value = "/member_list")
	public String list(Model model, HttpSession session) {
		String page = "redirect:/list";
		
		MemberDTO info = (MemberDTO) session.getAttribute("loginInfo");
		logger.info(info.getPerm());
		if(info.getPerm().equals("on")) {
			logger.info("memberList 요청");
			List<MemberDTO> list = service.memberList();
			model.addAttribute("list", list);
			page = "member_list";
		}
		
		return page;
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		logger.info("logout in");
		session.removeAttribute("loginInfo");
		return "redirect:/";
	}
	
	// ajax 통신 규칙
	// 1. Response 객체를 활용해야 한다. (페이지 이동만 되거나 객체에 프린트만 하거나)
	// 2. ajax 는 요청 보내는 페이지와 받는 페이지가 동일해야 한다. (페이지 이동 안됨)
	// 3. 반환 할때 JSON 형태로 반환해야 한다. ({키:값})
	// 4. json 과 비슷한 java 객체를 javascript 에서 인식 할 수 있도록 도와줄 라이브러리 (jackson-databind)
	@RequestMapping(value = "/overlay.do")
	@ResponseBody // response 객체에 반환하는 값을 담는 역할
	public Map<String, Object> overlay(String id) {
		logger.info("join id : {}", id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("use", service.overlay(id));
		// response 객체는 페이지 위에 그리는 역할이기 때문에
		// 반환 되는 값 자체를 기존 페이지 위에 덮어씌워 버린다.
		
		return map;
	}
}