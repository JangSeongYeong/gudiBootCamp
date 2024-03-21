package kr.co.photo.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.photo.member.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	// 에러 코드 관련 요청이 올 시
	@RequestMapping(value = "/error/404")
	public String notFound(Model model) {
		model.addAttribute("code","404");
		model.addAttribute("msg", "페이지 또는 요청 못찾음");
		return "error";
	}
	
	@RequestMapping(value = "/error/500")
	public String serverError(Model model) {
		model.addAttribute("code","500");
		model.addAttribute("msg", "서버 처리중 문제 발생");
		return "error";
	}
	
	// 기본 페이지
	@RequestMapping(value = "/")
	public String home() {
		logger.info("home page 진입");
		return "login";
	}
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, String pw, HttpSession session, Model model) {
		String page = "login";
		
		logger.info("id : {} / pw : {}",id ,pw);
		if (service.login(id, pw) != null) {
			session.setAttribute("loginId", id);
			page = "redirect:/list";
		} else {
			model.addAttribute("msg", "아이디 혹은 비밀번호가 맞지 않습니다.");
		}
		
		return page;
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		logger.info("logout in");
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
}
