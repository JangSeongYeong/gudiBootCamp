package kr.co.gudi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.gudi.dto.BoardDTO;
import kr.co.gudi.service.MainService;

@RestController
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired MainService service;
	
	@RequestMapping(value = "/")
	public Map<String, Object> list(){
		logger.info("list 요청");
		Map<String, Object> map = new HashMap<String, Object>();
		List<BoardDTO> list = service.list();
		map.put("list", list);
		logger.info("map : {}", list);
		return map;
	}
}
