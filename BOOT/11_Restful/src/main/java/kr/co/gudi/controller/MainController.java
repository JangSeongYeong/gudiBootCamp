package kr.co.gudi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.gudi.dto.UserInfo;

@RestController
//@RequestMapping(value = "/rest") // rest로 시작한 요청은 여기 컨트롤러로 오게 된다.
public class MainController {
	// @RestController 를 사용하면 모든 반환이 Response 객체에 쓰여지게 되므로  @ResponseBody 를 사용할 필요가 없다.
	// 다만 view 로 페이지 이동이 불가능 하다.
	
	Logger logger =LoggerFactory.getLogger(getClass());
	
	@GetMapping(value = "/")
	public ModelAndView home() { // ModelAndView 를 활용하면 RestController 에서도 페이지 이동이 가능하다.
		logger.info("메인 페이지 요청");
		return new ModelAndView("home");
	}
	
	/* method 종류
	 * GET : 특정 데이터를 조회할 경우
	 * POST : 특정 데이터 입력을 요청할 경우
	 * DELETE : 특정 데이터 삭제를 요청할 경우
	 * PUT : 특정 데이터 수정을 요청할 경우
	 * PATCH : 특정 데이터 수정(일부)를 요청할 경우
	 */
	
	
	@GetMapping(value = "/rest/list.ajax")
	public List<String> list(){
		List<String> list = new ArrayList<String>();
		list.add("하나");
		list.add("둘");
		list.add("셋");
		
		return list;
	}
	
	@GetMapping(value = "/rest/map.ajax")
	public Map<String, Object> map(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "hello");
		map.put("age", 25);
		map.put("merried", true);
		
		return map;
	}
	
	@GetMapping(value = "/rest/object.ajax")
	public UserInfo object() {
		UserInfo info = new UserInfo();
		info.setName("tester");
		info.setId("홍길동");
		info.setAge(80);
		info.setPromotion(false);
		return info;
	}
	
	// 파라메터로 받을 때 @RequestBody로 받아야 한다.
	@RequestMapping(value = "/rest/complex.ajax")
	public Map<String, Object> complex(
			@RequestBody Map<String, Object> param){
		
		// param : {values={name=숫자 넣기, num=[1, 2, 3, 4, 5]}}
		logger.info("param : {}", param);
		
		Map<String, Object> values = (Map<String, Object>) param.get("values");
		// values : {name=숫자 넣기, num=[1, 2, 3, 4, 5]}
		logger.info("values : {}" , values);
		
		String name = (String) values.get("name");
		// name : 숫자 넣기
		logger.info("name : "+name);
		
		
		List<Integer> num = (List<Integer>) values.get("num");
		logger.info("num : "+num);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		
		return map;
	}
	
	@GetMapping(value = "/rest/strMap.ajax")
	public Map<String, Object> strMap() throws Exception{
		// json 형태의 문자열(다른 서버에 요청할 경우 이렇게 json 형태의 문자열을 받게 된다.
		String json = "{\"no\":1, \"msg\":\"HashMap 변환 완료\", \"name\":\"장성영\"}"; // ""를 먼저 입력하고 외부에서 작성한 문자열을 넣으면 자동으로 이스케이프 문자가 들어간다.
		
		ObjectMapper mapper = new ObjectMapper(); // 양측의 있는 데이터를 서로 맞춰 보는 것을 mapper 라고 하는거다.
		// 어떤 문자열을 어떤 데이터 타입으로 변환 할래?
		// 아래는 Map의 제너릭이 지정되지 않아 비효율적이라고 경고! (노란줄)
		// Map<String, Object> result = mapper.readValue(json, Map.class);
		Map<String , Object> result = mapper.readValue(json, new TypeReference<Map<String, Object>>() {}); // 제너릭이 있으면 제너릭을 사용하라는 권고 사항, 위에랑 같이 해도 문제는 없다.
		logger.info("no : "+result.get("no"));
		logger.info("msg : "+result.get("msg"));
		logger.info("name : "+result.get("name"));
		
		return result;
	}
	
	@GetMapping(value = "/rest/strObject.ajax")
	public UserInfo strObject() throws Exception{
		String json = "{\"id\":\"json_ID\", \"name\":\"홍길동\", \"age\":33, \"promotion\":true}";
		ObjectMapper mapper = new ObjectMapper();
		UserInfo info = mapper.readValue(json, UserInfo.class);
		logger.info("id : "+info.getId());
		logger.info("name : "+info.getName());
		logger.info("age : "+info.getAge());
		logger.info("promotion : "+info.isPromotion()); // boolean이면 get이 아니라 is
		return info;
	}
	
}
