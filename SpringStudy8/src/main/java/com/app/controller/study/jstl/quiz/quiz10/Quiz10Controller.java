package com.app.controller.study.jstl.quiz.quiz10;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz10")
public class Quiz10Controller {

	@GetMapping("/A")
	public String A(HttpServletRequest request) {

		return "quiz/quiz10/a";
	}

//	@GetMapping("/B")
//	public String B(HttpServletRequest request) {
//
//	    request.getSession().setAttribute("msg", "FromB");
//
//
//	    return "quiz/quiz10/b";
//	}

	@GetMapping("/B")
	public String B(HttpSession session, Model model) {

		session.setAttribute("fromB", "FromB"); // session

//	    model.addAttribute("fromB","OriginalFromB");	//request

		return "quiz/quiz10/b";
	}

	@GetMapping("/A2")
	public String a2(Model model, HttpSession session) {
		
		model.addAttribute("fromMsg", "FromA");
		model.addAttribute("orgMsg", "OriginalA");
		
		model.addAttribute("A","A");
		
		//session scope 확인 -> request scope로 주입
		model.addAttribute("fromB",session.getAttribute("fromB"));
		
	    return "quiz/quiz10/ab";
	}

	@GetMapping("/B2")
	public String b2(Model model, HttpSession session) {

		model.addAttribute("fromMsg", "FromB");
		model.addAttribute("orgMsg", "OriginalB");

		session.setAttribute("fromB", "FromB");

		return "quiz/quiz10/ab";
	}
}
