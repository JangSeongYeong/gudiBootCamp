package kr.co.gudi.board.controller;

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

import kr.co.gudi.board.dto.BoardDTO;
import kr.co.gudi.board.service.BoardService;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardService service; 
	
	// 리스트 만들기
	@RequestMapping(value = "/list")
	public String list(Model model, HttpSession session) {
		logger.info("list 진입");
		
		String page = "login";
		String id = (String) session.getAttribute("loginId"); // Object로 받아오기에 String으로 형변환
		if(id != null) {
			page = "list";
			List<BoardDTO> list = service.list();
			logger.info("list size : "+list.size());
			model.addAttribute("list",list);
			model.addAttribute("loginBox", "<div>안녕하세요 "+id+" 님 <a href='logout'>로그아웃</a></div>");
		} else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}
		
		return page;
	}
	
	// 공지 삭제
	@RequestMapping(value = "/del")
	public String detele(String idx, HttpSession session) {
		logger.info("delete 진입");
		String page = "redirect:/";
		
		if(session.getAttribute("loginId") != null) {
			logger.info("삭제할 idx : "+idx);
			service.delete(idx);
			page = "redirect:/list";
		}
		
		return page;
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	// 글쓰기 페이지로
	@RequestMapping(value = "/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	// 작성한 글 데이터 베이스로 전송
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(HttpSession session, @RequestParam Map<String, String> param) {
		
		logger.info("params = {}",param);
		String page = "redirect:/list";
		if(session.getAttribute("loginId") != null) {
			int row = service.write(param);
			if(row < 1) {
				page = "writeForm";
			}
		}
		
		return page;
	}
	
	// 글 자세히 보기
	@RequestMapping(value="/detail")
	public String detail(String idx, HttpSession session, Model model) {
		String page = "redirect:/list";
		logger.info("detail idx = "+idx);
		
		if (session.getAttribute("loginId") != null) {
			BoardDTO bbs = service.detail(idx);
			model.addAttribute("bbs", bbs);
			page = "detail";
		}
		
		return page;
	}
	
	// 글 수정 페이지
	@RequestMapping(value="/updateForm")
	public String updateForm(String idx, HttpSession session, Model model) {
		String page = "redirect:/list";
		logger.info("update form idx = "+idx);
		
		if (session.getAttribute("loginId") != null) {
			BoardDTO bbs = service.updateForm(idx);
			model.addAttribute("bbs", bbs);
			page = "updateForm";
		}
		
		return page;
	}
	
	// 글 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public String update(HttpSession session, @RequestParam Map<String, String> param, Model model) {
		String page = "redirect:/list"; // 로그인 실패시 메시지 때문에
		logger.info("update 실행");
		
		if (session.getAttribute("loginId") != null ) {
			logger.info("param : {}", param);
			service.update(param);
			page = "redirect:/detail?idx="+param.get("idx");
		}
		
		return page;
	}
	
}
