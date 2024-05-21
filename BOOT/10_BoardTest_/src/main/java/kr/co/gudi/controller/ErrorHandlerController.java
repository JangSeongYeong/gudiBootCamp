package kr.co.gudi.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandlerController implements ErrorController{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/error")
	public String error(HttpServletRequest request, Model model) {
		logger.info("error 요청");
		model.addAttribute("code", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
		// 아래 내용은 사용자에게 보여줘서는 안되는 내용
		model.addAttribute("exception", request.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
		return "error";
	}
}
