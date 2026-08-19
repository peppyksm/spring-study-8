package com.app.controller.study.rest;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Controller  -> 기본 reurn이 view 자원 -> @responseBody를 붙여야 텍스트 리턴
@RestController  //기본 response로 text 리턴, 대신 이 컨트롤러에선 view 자원으로 return 불가능
public class Rest02Controller {
	
	//Controller 역활 + RESTAPI 형식 통신용 컨트롤러
	//내부 메소드 모두 text 리턴
	
	@GetMapping("rest/rest04")
	public String rest04(){
		//@RestController 이므로 기본적으로 텍스트 (rest/rest04) 를 리턴 (view자원 x)
		return "rest/rest04";
	}
	
	@GetMapping("rest/rest05")
	public String rest05() {
		return "rest/rest05 basic text";
	}
	
	//단순 텍스트 -? JSON 포맷
	@GetMapping("rest/rest06")
	public String rest06() {
		
		//JSON 포맷 리턴
		
		//직접 json 으로 만들기
		
		/*
			 {
			 	"id":"abc",
			 	"name:"abcname".
			 	"userType":"CUS",
			 	"pw:"pwpw"
			 }
		 */
		
		
		
		String result = "{\r\n"
				+ "			 	\"id\":\"abc\",\r\n"
				+ "			 	\"name:\"abcname\".\r\n"
				+ "			 	\"userType\":\"CUS\",\r\n"
				+ "			 	\"pw:\"pwpw\"\r\n"
				+ "			 }";
		return result;
	}
	
	
	
	@GetMapping("rest/rest07")
	public String rest07() {
		// 2) 라이브러리 활용 json-simple
		
		JSONObject obj = new JSONObject();
		obj.put("id", "abc");
		obj.put("name", "abcname");
		obj.put("pw", "abcabc");
		obj.put("userType", "ADM");
		
		String result = obj.toJSONString();
		return result;
	}
	
	@GetMapping("rest/rest08")
	public String rest08() {
		// 3) 라이브러리 활용 jackson
		
		User user = new User();
		user.setId("abc08");
		user.setPw("abc08pw");
		user.setName("abcname");
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER	);
		
		ObjectMapper mapper = new ObjectMapper();   //jackson 라이브러리
		String result = null;
		
		try{
			result = mapper.writeValueAsString(user);	//객체를 json으로 변환, try catch 필요
		}catch (JsonProcessingException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	@GetMapping("rest/rest09")
	public User rest09() {
		
		//4) 전제조건 : jackson 라이브러리 의존성 추가 상태
		// REST API 통신 -> text 반환
		// @responseBody	or	@RestController
		
		//객체를 리턴 -> 객체 구성을 JSON 포맷으로 변환한 후 return
		// **** jackson 라이브러리가 존재해야함 ****
		
		User user = new User();
		user.setId("abc09");
		user.setPw("abc09pw");
		user.setName("abcname09");
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER	);
		
		return user; //객체 리턴이 알아서 json format 변형
	}
	
}
