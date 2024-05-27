package kr.co.gudi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class ProfController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${prof.name}") private String name;
	@Value("${db.addr}") private String addr;
	@Value("${db.username}") private String username;
	@Value("${db.password}") private String password;
	
	@GetMapping(value = "/")
	public String home() {
		
		logger.info("profile name : "+name);
		logger.info("db addr : "+addr);
		logger.info("db username : "+username);
		logger.info("db password : "+password);
		
		// run as > Run Configuration
		// 1. 내장 톰켓
		// Spring Boot 옵션에서 profile 을 dev로 선택 후 실행
		
		// 2. 외장 톰켓 (둘 중에 선택)
		// arguments 에서 -Dspring.profiles.active=dev 추가
		// Environment 에서 spring.profiles.active 와 dev 추가
		
		// 3. 실제 톰켓에 배포시
		// conf/catalina.properties 에 다음 내용을 추가 해 준다.
		// spring.profiles.active=dev
		
		// 4. war 자체 실행시
		// java -jar ROOT.war --spring.profiles.active=dev
		
		return "OK";
	}
}
