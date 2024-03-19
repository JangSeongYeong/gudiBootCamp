package kr.co.gudi.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.gudi.dto.MemberDTO;
import kr.co.gudi.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value = "/")
	public String home() {
		logger.info("main page");
		return "login";
	}
	
	// 이제는 GET으로 받는 애들은 method를 안붙인다. POST로 받는 애들만
	@RequestMapping(value = "/joinForm")
	public String joinForm() {
		logger.info("join Form 이동");
		return "joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, @RequestParam Map<String, String> param) { // @RequestParam 이 없으면 받아오지 못한다.
		String page = "joinForm";
		String msg = "회원가입에 실패 했습니다.";
		
		logger.info("param : " + param);
		
		int row = service.join(param);
		logger.info("insert count : "+row);
		
		if (row == 1) {
			page = "login";
			msg = "회원가입에 성공했습니다.";
		}
		
		model.addAttribute("msg", msg);
		
		return page;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session, String id, String pw) { // 2정도는 그냥 받아오는게 편함
		String page = "login";
		logger.info("id : {} / pw : {}",id,pw);
		
		String loginId = service.login(id,pw);
		logger.info("loginId : "+loginId); // 성공시 아이디를 받아오고 , 실패했을 시 null을 받아온다.
		
		if (loginId != null) {
			page = "redirect:/list";
			session.setAttribute("loginId", loginId);
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인해주세요");
		}
		
		return page;
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpSession session) {
		logger.info("list 요청");
		String page = "redirect:/";
		
		if (session.getAttribute("loginId") != null) {
			page = "list";
			List<MemberDTO> list = service.list();
			model.addAttribute("list", list);
		}
		
		return page;
	}

	@RequestMapping(value = "detail")
	public String detail(Model model, HttpSession session, String id) {
		logger.info("detail 요청");
		String page = "redirect:/list"; // 실패하면 list에 남아있게 하기 위해서
		
		if (session.getAttribute("loginId") != null) {
			logger.info("detail view id : "+id);
			MemberDTO dto = service.detail(id);
			model.addAttribute("member", dto);
			page = "detail";
		} else {
			page = "redirect:/";
		} 
		
		return page;
	}

	@RequestMapping(value = "/del")
	public String delete(HttpSession session, String id) {
		logger.info("delete 요청");
		String page = "redirect:/";
		
		if (session.getAttribute("loginId") != null) {
			logger.info("delete id : "+id);
			service.delete(id);
			page = "redirect:/list";
			logger.info("삭제 처리 완료");
		}
		
		return page;
	}
	
}
