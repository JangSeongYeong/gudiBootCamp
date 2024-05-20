package kr.co.gudi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.BoardService;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardService service;

	@GetMapping(value="/")
	public ModelAndView getBBSList() {
		logger.info("게시물 목록 조회");
		return service.getBBSList();
	}
	
	@GetMapping(value = "/detail")
	public ModelAndView detail(String idx) {
		logger.info("idx : "+idx);
		return service.detail(idx);
	}
}
