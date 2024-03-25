package our.first.project.board.controller;

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
import org.springframework.web.multipart.MultipartFile;

import our.first.project.board.dto.BoardDTO;
import our.first.project.board.service.BoardService;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired BoardService service;
	
	@RequestMapping(value = "/list")
	public String list(HttpSession session, Model model) {
		logger.info("list in");
		String page = "login";
		String id = (String)session.getAttribute("loginId");
		if (id != null) {
			page = "list";
			List<BoardDTO> list = service.list();
			logger.info("list : "+list);
			model.addAttribute("list" ,list);
			model.addAttribute("loginBox", "<div>안녕하세요 "+id+"님 <a href='./logout'>로그아웃</a></div>");
		} else {
			model.addAttribute("msg", "로그인이 필요한 서비스입니다.");
		}
		
		return page;
	}
	
	// 글쓰기 폼으로 이동
	@RequestMapping(value = "/writeForm")
	public String writeForm(HttpSession session) {
		String page = "redirect:/list";
		
		if (session.getAttribute("loginId") != null ) {
			page = "writeForm";
		}
		
		return page;
	}
	
	// 글 쓰기
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(MultipartFile[] photos, HttpSession session, @RequestParam Map<String, String> param) {
		logger.info("write in");
		String page = "redirect:/list";
		
		if (session.getAttribute("loginId") != null ) {
			logger.info("param : "+param);
			int row = service.write(photos, param);
			if (row < 1) {
				page = "writeForm";
			}
		}
		
		return page;
	}
	
	// detail
	// 글 상세
	@RequestMapping(value = "/detail")
	public String detail(HttpSession session, String idx, Model model) {
		logger.info("detail in");
		String page = "redirect:/list";
		logger.info("detail idx : "+idx);
		
		if (session.getAttribute("loginId") != null ) {
			service.detail(idx,model);
			page = "detail";
		}
		
		return page;
	}
	
	// 글 수정 페이지
	@RequestMapping(value = "/updateForm")
	public String updateForm(HttpSession session, String idx, Model model) {
		String page = "redirect:/list";
		
		if (session.getAttribute("loginId") != null ) {
			service.updateForm(idx, model);
			page = "updateForm";
		}
		
		return page;
	}
	
	
	
	
	// 회원리스트로 이동
	@RequestMapping(value = "/memberListForm")
	public String memberListForm(HttpSession session) {
		String page = "redirect:/list";
		
		if (session.getAttribute("loginId") != null) {
			page = "redirect:/memberList";
		}
		
		return page;
	}
	
}
