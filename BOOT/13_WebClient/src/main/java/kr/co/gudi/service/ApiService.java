package kr.co.gudi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.BodyInserters.FormInserter;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	// 다른 서버로 요청을 보내고, 응답을 받는 기능 만들기
	// WebClient 는 Spring 5.0 에서 부터 지원하는 라이브러리이다.
	// HttpConnection(Spring 기본 내장) -> RestTemplate 등을 사용했었다.
	// Non-Blocking 방식을 지원하기 때문에 비동기 처리가 가능하여 속도면에사 우월하다. (많은 통신이 이루어질 때 유리)
	// get 방식 전송과 post 방식 전송이 조금 다르다.
	
	public Map<String, String> getSend(String msg) {
		
		// 1. 어디로 보낼지
		WebClient client = WebClient.create("http://localhost:8080");
		
		// 2. 전송 방식 지정
		// retrieve() : 전송 후 body 값을 받아온다.
		// exchange() : 전송 후 상태값 헤더값도 받아온다.(테스트 이외에는 잘 사용하지 않음)
		// bodyToMono() : 동기 통신시 사용(한번에 1개 요청 처리시)
		// bodyToFlux() : 비동기 통신시 사용(한번에 여러개의 요청 처리시)
		Mono<Map> mono = client.get()
			.uri("/return/"+msg) // 3. 상세 URL 추가(있으면)
			.retrieve() // 4. 전송
			.bodyToMono(Map.class); // 5. 받을 방식 지정
		
		// 6. 받아온 Mono 로 부터 자바 객체를 빼온다.
		Map<String, String> resp = mono.block();
		logger.info("response : "+resp);
		
		return resp;
	}

	public List<Map<String, Object>> postSend(String val, String key) {
		
		// 1. 어디로 보낼지
		WebClient client = WebClient.create("http://localhost:8080");
		
		// 2. 파라메터 추가
		FormInserter<String> form = BodyInserters.fromFormData("cnt", val);
		// 파라메터를 추가하고 싶다면 아래 방법도 있음(MultiValueMap 에 담아서 한번에 보내는게 더 낫다.)
		// form.with("name", "value");
		
		// 3. 전송 방식 지정 + 4. 상세 URL 추가(있으면) + 5. 전송
		Mono<List> mono = client.post().uri("/listReturn")
			.header("authorization", key).body(form)
			.retrieve().bodyToMono(List.class);
		
		// List<Map<String, Object>> list = mono.block(); // 이 방식이 간단하긴 하지만 속도면에서 다른 방식을 추천한다.
		List<Map<String, Object>> list = mono.flux().toStream().findFirst().get(); // 동기 방식 보다는 비동기 방식이 속도면에서 빠르기 떄문에
		logger.info("response : "+list);
		
		return list;
	}

	public List<Map<String, Object>> fluxTest() {
		
		WebClient client = WebClient.create("http://localhost:8080");
		
		// param 추가
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("age", 40);
		json.put("name", "kim");
		json.put("married", false);
		json.put("score", new int[] {30, 40, 50, 60, 70, 80, 90});
		
		// json 형태로 파라메터를 보내고 싶을 경우
		// bodyBalue() 를 사용한다.
		// 받는 곳에서는 @RequestsBody 로 받아줘야 한다.
		Flux<Map> flux = client.post().uri("/fluxReturn")
			.bodyValue(json).retrieve().bodyToFlux(Map.class);
		
		List<Map<String, Object>> list = flux.toStream().collect(Collectors.toList());
		logger.info("list : {}",list);
		return list;
	}

}
