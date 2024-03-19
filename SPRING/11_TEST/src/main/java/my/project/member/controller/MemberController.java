package my.project.member.controller;

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

import my.project.member.dto.MemberDTO;
import my.project.member.service.MemberService;

@Controller
public class MemberController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MemberService service;
	
	@RequestMapping(value = "/")
	public String home() {
		logger.info("main 진입");
		return "login";
	}
	
	@RequestMapping(value = "/joinForm")
	public String joinForm() {
		logger.info("joinForm 진입");
		return "joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, @RequestParam Map<String, String> map) {
		logger.info("회원가입 실행");
		String page = "joinForm";
		String msg = "회원가입에 실패했습니다.";
		
		if (service.join(map) == 1) {
			msg = "회원가입에 성공했습니다.";
			page = "login";
		} 
		
		model.addAttribute("msg", msg);
		
		return page;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, String pw, HttpSession session, Model model) {
		logger.info("login 진입");
		String page = "login";
		String loginId = service.login(id, pw);
		logger.info("id : {} / pw : {}", id, pw);
		if (loginId != null) {
			session.setAttribute("loginId", loginId);
			page = "redirect:/list";
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인해주세요");
		}
		
		return page;
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpSession session) {
		logger.info("list 진입");
		String page = "redirect:/";
		
		if (session.getAttribute("loginId") != null) {
			List<MemberDTO> list = service.list();
			model.addAttribute("list", list);
			page = "list";
		}
		
		return page;
	}
	
	@RequestMapping(value = "/detail")
	public String detail(String id, HttpSession session, Model model) {
		logger.info("detail 진입");
		String page = "redirect:list";
		
		if (session.getAttribute("loginId") != null ) {
			logger.info("detail id = "+id);
			MemberDTO dto = service.detail(id);
			model.addAttribute("member", dto);
			page = "detail";
		} else {
			page = "redirect:/";
		}
		
		return page;
	}
	
	@RequestMapping(value = "/del")
	public String delete(String id, HttpSession session) {
		logger.info("delete 진입");
		String page = "redirect:/";
		
		if (session.getAttribute("loginId") != null) {
			logger.info("delete id : "+id);
			service.delete(id);
			page = "redirect:list";
		}
		
		return page;
	}
	
	
}
