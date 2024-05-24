package kr.co.gudi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.gudi.util.LoginChecker;

@Configuration // 이 어노테이션이 있어야 설정 클래스로 인식 된다.
public class InterCepterConfig implements WebMvcConfigurer {
	
	// 인터셉터에 등록할 클래스를 가져온다.
	@Autowired LoginChecker checker;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 1. 인터셉터에 등록할 로직 추가
		
		// 2. 인터셉터가 가로챌 url 패턴 등록
		
		// 3. 인터셉터가 예외로 둘 url 패턴 등록
		
		List<String> excludeList = new ArrayList<String>();
		excludeList.add("/");
		excludeList.add("/join*"); // join 뒤에 뭐가 오든지
		excludeList.add("/login.*"); // login. 뒤에 뭐가 오든지
		excludeList.add("/resources/**"); // resources/ 뒤에 뭐가 오든지
		
		registry.addInterceptor(checker)
			.addPathPatterns("/**") // 리스트로 넣는 방법도 있지만 /**를 통해서 모든 url에 인터셉터를 거는것
			.excludePathPatterns(excludeList);  // 예외로 둘 패턴 List로 작성해 등록
		
		// ip 추적에 대한 내용도 여기서 하면 된다.
	}
	
	
}
