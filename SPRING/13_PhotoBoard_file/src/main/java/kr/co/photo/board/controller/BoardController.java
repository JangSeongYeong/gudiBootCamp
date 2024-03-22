package kr.co.photo.board.controller;

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

import kr.co.photo.board.dto.BoardDTO;
import kr.co.photo.board.service.BoardService;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardService service;
	
	// 리스트
	// 로그인이 필요한 서비스라는 alert을 넣어주었기에 이후 세션없는 것에 대한 이동은 /list 로 
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
	
	// 글 삭제
	@RequestMapping(value = "/del")
	public String delete(HttpSession session, String idx) {
		logger.info("delete in");
		String page = "redirect:/list";
		
		if (session.getAttribute("loginId") != null) {
			logger.info("delete idx : "+idx);
			page = "redirect:/list";
			service.delete(idx);
		}
		
		return page;
	}
	
	// 글 상세
	@RequestMapping(value = "/detail")
	public String detail(HttpSession session, String idx, Model model) {
		logger.info("detail in");
		String page = "redirect:/list";
		logger.info("detail idx : "+idx);
		
		if (session.getAttribute("loginId") != null ) {
			//BoardDTO bbs = service.detail(idx);
			//model.addAttribute("bbs", bbs);
			// model 줄테니 여기에 bbs 와 photos 담아와라
			service.detail(idx,model);
			page = "detail";
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
	public String write(MultipartFile[] photos, HttpSession session, @RequestParam Map<String, String> map) {
		logger.info("write in");
		String page = "redirect:/list";
		
		if (session.getAttribute("loginId") != null ) {
			logger.info("Map : "+map);
			int row = service.write(photos, map);
			if (row < 1) {
				page = "writeForm";
			}
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
	
	// 글 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MultipartFile[] photos, HttpSession session, @RequestParam Map<String, String> map) {
		String page = "redirect:/list";
		
		if (session.getAttribute("loginId") != null ) {
			String idx = map.get("idx");
			logger.info("map : {}"+map);
			logger.info("update idx : "+idx);
			
			logger.info("photos : {}", photos);
			service.update(photos, map);
			page = "redirect:/detail?idx="+idx;
		}
		
		return page;
	}
	
}
