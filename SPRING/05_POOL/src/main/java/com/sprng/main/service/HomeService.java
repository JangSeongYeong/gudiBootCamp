package com.sprng.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sprng.main.dao.HomeDAO;

public class HomeService {

	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);
	
	public String dbConnect() {
		String msg = "DB 연결 실패";
		logger.info("Service home 접근");
		
		HomeDAO dao = new HomeDAO();
		
		if(dao.dbConnect()) msg="DB 연결 성공";
		
		return msg;
	}

	public String poolConnect() {
		logger.info("pool service");
		String msg = "pool 접속에 실패했습니다.";
		
		HomeDAO dao = new HomeDAO();
		
		if(dao.poolConnect()) {
			msg = "pool 접속에 성공 했습니다.";
		}
		
		return msg;
	}
	
}
