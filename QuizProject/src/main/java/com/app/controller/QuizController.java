package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {

	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@RequestMapping("/product")
	public String product() {
		return "product";
	}
}