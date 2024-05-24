package kr.co.gudi.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.gudi.member.service.MemberService;

@Controller
public class MemberController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	private final MemberService memberService;
	
	private MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@GetMapping(value="/")
	public String home() {
		return "login";
	}
	
	
	// 로그인
	@PostMapping(value="/login.do")
	public String login(HttpSession session, Model model, String id, String pw) {
		return memberService.login(session, model, id, pw);
	}
	// 로그아웃
	@GetMapping(value="/logout")
	public String login(HttpSession session, Model model) {
		session.removeAttribute("loginId");
		model.addAttribute("msg", "로그아웃 성공, 로그인 페이지로 되돌아 갑니다...");
		
		return "login";
	}

}
