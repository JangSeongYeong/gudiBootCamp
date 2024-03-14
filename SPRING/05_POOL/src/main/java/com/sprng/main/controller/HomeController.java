package com.sprng.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sprng.main.service.HomeService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("controller home 접근");
		
		HomeService service = new HomeService();
		
		String msg = service.dbConnect();
		logger.info("최종 msg : "+msg);
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
	@RequestMapping(value = "/pool", method = RequestMethod.GET)
	public String pool(Model model) {
		
		logger.info("/pool 요청");
		HomeService service = new HomeService();
		
		String msg = service.poolConnect();
		logger.info("msg : "+msg);
		model.addAttribute("msg", msg);
		
		return "index"; // 뷰 페이지 지정
	}
}
