package our.first.project.member.controller;

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

import our.first.project.member.dto.MemberDTO;
import our.first.project.member.service.MemberService;

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
	
	@RequestMapping(value = "/")
	public String home() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, String id, String pw, Model model) {
		String page = "login";
		logger.info("id : {}, pw : {}", id, pw);
		if (service.login(id, pw) != null) {
			session.setAttribute("loginId", id);
			page = "redirect:/list";
		} else {
			model.addAttribute("msg", "아이디 혹은 비밀번호를 확인해주세요");
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
	
	@RequestMapping(value = "/memberList")
	public String memberList(HttpSession session, Model model) {
		logger.info("member List in");
		String page = "login";
		String id = (String)session.getAttribute("loginId");
		logger.info("현재 로그인한 id : "+ id);
		if (id != null) {
			page = "memberList";
			List<MemberDTO> list = service.memberList();
			logger.info("list : "+list);
			model.addAttribute("list" ,list);
			model.addAttribute("loginBox", "<div>안녕하세요 "+id+"님 <a href='./logout'>로그아웃</a></div>");
		} else {
			model.addAttribute("msg", "관리자만 사용가능한 영역입니다.");
		}
		
		return page;
	}
	
	@RequestMapping(value = "/joinForm")
	public String joinForm() {
		logger.info("joinForm IN");
		return "joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, @RequestParam Map<String, String> param) {
		String page = "joinForm";
		String msg = "회원가입에 실패했습니다.";
		
		logger.info("param : " + param);
		
		int row = service.join(param);
		logger.info("insert row : "+row);
		
		if (row == 1) {
			page = "login";
			msg = "회원가입에 성공했습니다.";
		}
		
		model.addAttribute("msg", msg);
		
		return page;
	}
}
