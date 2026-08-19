package com.app.controller.study.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Rest01Controller {

	@GetMapping("/rest/rest01")
	public String rest01() {
		
		return "rest/rest01";	//view 경로 자원
	}
	
	@ResponseBody  		
	@GetMapping("/rest/rest02")
	public String rest02() {
		//ResponseBody
		//rest01처럼 view 자원으로 연결되는것이 아니라 return되는 값을 넘김
		return "rest/rest02";
	}
	
	@ResponseBody  		
	@GetMapping("/rest/rest03")
	public String rest03() {
		return "text text rest api test";
	}
}
