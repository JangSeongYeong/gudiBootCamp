package kr.co.gudi.contoller;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.MainService;

@RestController
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MainService service;
	
	@GetMapping(value = "/")
	public ModelAndView home() {
		logger.info("팀 리스트 이동");
		return new ModelAndView("list");
	}
	
	@GetMapping(value = "/list.ajax")
	public Map<String, Object> listAjax() {
		logger.info("팀 리스트 요청 - ajax");
		return service.listAjax();
	}
}
