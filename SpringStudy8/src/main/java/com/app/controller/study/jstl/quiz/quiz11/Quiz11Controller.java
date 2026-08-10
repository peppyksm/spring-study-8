package com.app.controller.study.jstl.quiz.quiz11;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz11")
public class Quiz11Controller {
	
	@GetMapping("/first")
	public String first(HttpSession session) {
		if(session.getAttribute("accessUrl") != "/firsthide3") {
			session.removeAttribute("hide3");
		}
		session.setAttribute("accessUrl", "/first");
		
		return "quiz/quiz11/targetPage";
		
	}
	
	
	
	@GetMapping("/firsthide1")
	public String firstHide1(HttpSession session) {
		session.removeAttribute("hide3");
		session.setAttribute("accessUrl", "/firstHide1");
		return "quiz/quiz11/targetPage";
	}
	
	@GetMapping("/firsthide2")
	public String firstHide2(HttpSession session) {
		session.removeAttribute("hide3");
		session.setAttribute("accessUrl", "/first");
		return "redirect:/quiz11/first";
	}
	
	@GetMapping("/firsthide3")
	public String firstHide3(HttpSession session) {
		session.setAttribute("accessUrl", "/firsthide3");
		session.setAttribute("hide3", "hide3");
		return "redirect:/quiz11/first";
	}
}
