package kr.co.gudi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogContoller {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/")
	public String home() {
		logger.info("home page 요청");
		return "home page 방문";
	}
	
	@RequestMapping(value = "/root")
	public String root() {
		logger.warn("root page 요청");
		return "root page 방문";
	}
	
	@RequestMapping(value = "/index")
	public String index() {
		// 로그레벨을 info 로 잡았기 때문에 info 보다 덜 중요한 debug, trace 등은 찍히지 않는다.
		logger.debug("index page 요청");
		return "index page 방문";
	}
}
