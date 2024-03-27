package team.first.project.member.controller;

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

import team.first.project.member.dto.MemberDTO;
import team.first.project.member.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MemberService memberService;
	
	@RequestMapping(value = "/")
	public String home() {
		logger.info("main In");
		return "login";
	}
	
	@RequestMapping(value = "/join.go")
	public String joinForm() {
		logger.info("join.go");
		return "joinForm";
	}
	
	@RequestMapping(value = "/overlay.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> overlay(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("overlay : "+ id);
		map.put("use", memberService.overlay(id));
		
		return map;
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> param, Model model) {
		logger.info("join map : ", param);
		String page = "joinForm";
		String msg = "회원가입에 실패하셨습니다.";
		if (memberService.join(param) > 0) {
			page = "login";
			msg = "회원가입에 성공하셨습니다.";
		}
		
		model.addAttribute("msg", msg);
		
		return page;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpSession session, String id, String pw, Model model) {
		logger.info("id : {}, pw : {} ", id, pw);
		String page = "login";
		String msg = "아이디 혹은 비밀번호를 확인해주세요.";
		
		MemberDTO info = memberService.login(id, pw);
		
		if(info != null) {
			page = "list";
			session.setAttribute("loginInfo", info);
		} else {
			model.addAttribute("msg", msg);
		}
		
		
		return page;
	}
	
}
