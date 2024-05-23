package kr.co.gudi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	// application.properties 에 있는 값 가져오기
	@Value("${user.id}") private String user_id;
	@Value("${user.pw}") private String user_pw;
	@Value("${user.ip}") private String user_ip;
	
	public ModelAndView login(String id, String pw, String ip) {
		logger.info("user id : "+user_id);
		logger.info("user pw : "+user_pw);
		logger.info("user ip : "+user_ip);
		
		ModelAndView mav = new ModelAndView();
		String page = "login";
		String msg = "관리자 계정으로 접속할 수 없습니다.";
		
		if (id.equals(user_id) && pw.equals(user_pw) && ip.equals(user_ip)) {
			page = "result";
			msg = "관리자님 안녕하세요!";
		}
		
		mav.addObject("msg", msg);
		mav.setViewName(page);
		return mav;
	}
	
	
}
