package kr.co.gudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.MemberService;

@Controller
public class MemberContoller {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	private final MemberService service;
	
	public MemberContoller(MemberService service) {
		this.service = service;
	}
	
	@GetMapping(value = "/")
	public String home() {
		return "login";
	}
	
	@PostMapping(value = "/login.do")
	public ModelAndView login(String id, String pw, HttpServletRequest request) { // request에는 id, pw 뿐만 아니라 ip 주소와 같이 전송에 대한 모든 정보를 가지고 있다.
		String ip = request.getRemoteAddr();
		
		logger.info("id : "+id);
		logger.info("pw : "+pw);
		logger.info("ip : "+ip); // 0:0:0:0:0:0:0:1 -> 127.0.0.1
		
		// IPV6 > IPV4 로 변환할 경우
		// run as > run configuration > arguments > vm 선택 후 아래 내용 추가
		// -Djava.net.preferIPv4Stack=true
		
		return service.login(id, pw, ip);
	}
}
