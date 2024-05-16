package kr.co.gudi.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/")
	public String home() {
		logger.info("메인 페이지 요청");
		// main 이라는 문자열에
		// prefix = /views/
		// suffix = .jsp
		// 를 이용하여 /view/main.jsp로 이동시킨다.
		return "main";
	}
	
	@RequestMapping(value = "/calc", method = RequestMethod.POST)
	public String calc(Model model, @RequestParam Map<String, String> param) {
		int result = 0;
		
		try {
			int val1Int = Integer.parseInt(param.get("val1"));
			int val2Int = Integer.parseInt(param.get("val2"));
			
			switch (param.get("oper")) {
			case "+":
				result = val1Int+val2Int;
				break;
			case "-":
				result = val1Int-val2Int;
				break;
			case "*":
				result = val1Int*val2Int;
				break;
			default:
				result = val1Int/val2Int;
				break;
			}			
		} catch (Exception e) {
			result = 0;
		}
		model.addAttribute("result", result);
		
		return "result";
	}
	
	
}
