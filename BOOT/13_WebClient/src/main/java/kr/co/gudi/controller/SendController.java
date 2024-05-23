package kr.co.gudi.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import kr.co.gudi.service.ApiService;

@RestController
public class SendController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private final ApiService service;
	
	public SendController(ApiService service) {
		this.service = service;
	}
	
	@GetMapping(value = "/get/send/{val}")
	public Map<String, String> getSend(@PathVariable String val){
		logger.info("param : "+val);
		return service.getSend(val);
	}
	
	@PostMapping(value = "/post/send/{val}")
	public List<Map<String, Object>> postSend(@PathVariable String val, 
			@RequestHeader Map<String, String> header){
		logger.info("val : "+val);
		logger.info("header : "+header);
		String key = header.get("authorization"); // Authorization 로 보내더라도 java에서 받을 떄는 authorization로 바뀜
		return service.postSend(val, key);
	}
	
	@GetMapping(value = "/get/fluxTest")
	public List<Map<String, Object>> fluxTest(){
		return service.fluxTest();
	}
}
