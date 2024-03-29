package com.sprng.main.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

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
		return "index";
	}
	
	@RequestMapping(value = "/stmt")
	public String stmt(Model model) {		
		logger.info("stmt 실행 요청");
		
		HomeService service = new HomeService();
		
		String msg = service.createTable();
		logger.info("결과 메시지 : "+msg);
		model.addAttribute("result", msg);
		return "index";
	}
	
	// 회원 가입 정보를 DB - member 테이블에 넣는 메서드 (sql 문에서 member라고 지정해뒀기에)
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert(Model model, HttpServletRequest req) throws UnsupportedEncodingException {
		logger.info("inset 실행 요청");
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		logger.info(id+" "+pw+" "+name+" "+age+" "+gender+" "+email);
		
		HomeService  service = new HomeService();
		
		int row = service.insert(id,pw,name,age,gender,email);
		model.addAttribute("row",row);
		
		return "index";
	}

	// member 테이블의 데이터를 출력하는 메서드
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		logger.info("회원 목록 요청");
		
		HomeService service = new HomeService();
		service.list();
		
		
		return "index";
	}
	
}
