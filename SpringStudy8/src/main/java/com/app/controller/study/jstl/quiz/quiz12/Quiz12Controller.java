package com.app.controller.study.jstl.quiz.quiz12;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz12Controller {
	int count = 0;
	
	@GetMapping("/quiz12/login")
	public String getLogin() {
		
		return "/quiz/quiz12/login";
	}
	
	@PostMapping("/quiz12/login")
	public String postLogin(@RequestParam String id, String pw, HttpSession session) {
		
		session.setAttribute("ID", id);
		session.setAttribute("PW", pw);
		
		return "redirect:/quiz12/count";
	}
	
	@GetMapping("/quiz12/count")
	public String count(HttpSession session) {
		
		if(session.getAttribute("ID") != null) {
			count++;
		}
		session.setAttribute("count", count);
		
		return "/quiz/quiz12/count";
	}
	
	@GetMapping("/quiz12/logout")
	public String logout(HttpSession session) {
		
		count = 0;
		session.setAttribute("count", count);
		session.removeAttribute("ID");
		session.removeAttribute("PW");
		
		return "redirect:/quiz12/count";
	}
}
