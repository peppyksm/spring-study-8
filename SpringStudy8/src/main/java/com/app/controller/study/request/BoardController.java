package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("/board/notice")
	public String notice() {
		return "board/notice";
	}
	
	@GetMapping("/board/faq")
	public String faq() {
		return "board/faq";
	}
}
