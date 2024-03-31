package my.solo.project.member.controller;


import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;

import my.solo.project.member.dto.MemberDTO;
import my.solo.project.member.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MemberService memberService;
	
	// 기본 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}
	
	// 회원가입 이동
	@RequestMapping(value = "/join.go", method = RequestMethod.GET)
	public String joinGo() {
		return "joinForm";
	}
	
	// 아이디 중복 검사
	@RequestMapping(value = "/overlay.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> overlay(String id) {
		logger.info("overly chekc Id : "+id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("use", memberService.overlay(id));
		
		return map;
	}
	
	// 회원가입
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> map, Model model) {
		String page = "joinForm";
		String msg = "회원가입에 실패했습니다. 다시 시도해주세요";
		logger.info("join Info - Data = {}", map);
		
		if (memberService.join(map) == 1) {
			page = "login";
			msg = "회원가입 성공";
		}
		model.addAttribute("msg", msg);
		
		return page;
	}

	// 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, String id, String pw) {
		String page = "login";
		MemberDTO loginInfo = memberService.login(id, pw);
		logger.info("loginInfo : {}", loginInfo);
		if (loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
			page = "list";
		} else {
			model.addAttribute("msg","로그인에 실패했습니다.");
		}
		
		return page;
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public String login(HttpSession session) {
		String page = "redirect:/";
		session.removeAttribute("loginInfo");
		return page;
	}
}
