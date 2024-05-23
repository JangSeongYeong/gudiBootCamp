package kr.co.gudi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecvController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value = "/return/{msg}")
	public Map<String, String> getReturn(@PathVariable String msg){
		logger.info("저쪽 서버로 보내 보낸 내용 : "+msg);
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "네가 보낸 메시지 : "+msg);
		return map;
	}
	
	
	@PostMapping(value = "/listReturn")
	public List<Map<String, Object>> listReturn(String cnt, 
			@RequestHeader Map<String, String> header){
		
		int count = Integer.parseInt(cnt);
		String key = header.get("authorization");
		logger.info("cnt = "+cnt);
		logger.info("key = "+key);
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		
		for (int i = 0; i < count; i++) {
			map = new HashMap<String, Object>();
			map.put("no", i);
			map.put("name", String.valueOf(i));
			map.put("salary", i*100000);
			list.add(map);
		}
		
		return list;
	}
	
	@PostMapping(value = "/fluxReturn")
	public List<Map<String, Object>> fluxReturn(@RequestBody Map<String, Object> param){
		logger.info("json param : {}", param);
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		
		for (int i = 1; i < 11; i++) {
			map = new HashMap<String, Object>();
			map.put("no", i);
			map.put("name", String.valueOf(i));
			map.put("salary", i*100000);
			list.add(map);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
}
