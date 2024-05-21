package kr.co.gudi.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService memberService;
	
	@RequestMapping(value = "/")
	public String home() {
		logger.info("로그인 페이지 요청");
		return "login";
	}
	
	@PostMapping(value = "/login.do")
	public ModelAndView login(HttpSession session, @RequestParam Map<String, String> params) {
		logger.info("prams : "+ params);
		return memberService.login(session, params);
	}
	
	@GetMapping(value = "/logout.do")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("loginInfo");
		mav.setViewName("login");
		mav.addObject("msg", "로그아웃 되셨습니다.");
		return mav;
	}
	
}
