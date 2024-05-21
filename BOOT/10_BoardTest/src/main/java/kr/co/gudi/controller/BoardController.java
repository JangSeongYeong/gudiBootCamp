package kr.co.gudi.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.BoardService;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardService boardService;
	
	@GetMapping(value = "/list")
	public ModelAndView list(HttpSession session) {
		logger.info("list 요청");
		return boardService.list(session);
	}
	
	@GetMapping(value = "/writeForm.go")
	public String writeFormGo(HttpSession session) {
		String page = "redirect:list";
		if (session.getAttribute("loginInfo") != null) {
			page= "writeForm";
		} 
		return page;
	}
	
	@PostMapping(value = "/write.do")
	public ModelAndView write(HttpSession session, @RequestParam Map<String, String> params) {
		logger.info("writeData : "+params);
		return boardService.write(session, params);
	}
	
	@GetMapping(value = "/detail.go")
	public ModelAndView detail(HttpSession session, String idx) {
		logger.info("idx : "+idx);
		return boardService.detail(session, idx);
	}
	
	@GetMapping(value = "/updateForm.go")
	public ModelAndView updateFormGo(HttpSession session, String idx) {
		logger.info("idx : "+idx);
		return boardService.updateGo(session, idx);
	}
	
	@PostMapping(value = "/update.do")
	public ModelAndView update(HttpSession session, @RequestParam Map<String, String> params) {
		logger.info("update Date : "+params);
		return boardService.update(session, params);
	}
	
	@GetMapping(value = "/delete.do")
	public ModelAndView delete(HttpSession session, String idx) {
		logger.info("delete idx : "+idx);
		return boardService.delete(session, idx);
	}
	
}
