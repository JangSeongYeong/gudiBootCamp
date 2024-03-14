package com.sprng.main;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		return "home";
	}
	
	// 버튼을 눌렀을때 val1, val2 , oper의 값을 logging으로 출력
	@RequestMapping(value = "/calc", method = RequestMethod.POST)
	public String calc(Model model, HttpServletRequest req) {
		logger.info("calc 요청");
		
		String val1 = req.getParameter("val1");
		String val2 = req.getParameter("val2");
		String oper = req.getParameter("oper");
		
		logger.info(val1+" "+oper+" "+val2);
		
		int su1 = Integer.parseInt(val1);
		int su2 = Integer.parseInt(val2);
		int result = 0;
		
		switch (oper) {
			case "+":
				result = su1+su2;
				break;
			case "-":
				result = su1-su2;
				break;
			case "*":
				result = su1*su2;
				break;
			case "/":
				result = su1/su2;
				break;
		}
		
		model.addAttribute("result", result);
		
		return "result";
	}
	
	
}
