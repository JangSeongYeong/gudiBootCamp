package kr.co.gudi.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.MainService;

@RestController // 페이지 이동보다 ajax 통신이 더 많을 것 같으면 사용
public class MainController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	// @Autowired MainService service; // 필드 주입
	private final MainService service;
	
	// 생성자 주입 - 주로 서비스가 다른 서비스를 물고 올때 사용
	public MainController(MainService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		return new ModelAndView("list");
	}
	
    @GetMapping(value = "/getTeamList.ajax")
    public Map<String, Object> list() {
    	logger.info("프로젝트 상세 내용 출력");
    	return service.getTeamList();
    }
    
    // url 에 값이 들어올 경우 다음과 같이 받아준다.
    @PutMapping(value = "/update/{col}/{val}/{pk}")
    public Map<String, Object> update(
    		@PathVariable Map<String, Object> param){ // 경로안에 변수를 받겠다.
    	Map<String, Object> result = new HashMap<String, Object>();
    	logger.info("update 요청 : "+param);
    	int row = service.update(param);
    	result.put("result", row);
    	return result;
    }
}
