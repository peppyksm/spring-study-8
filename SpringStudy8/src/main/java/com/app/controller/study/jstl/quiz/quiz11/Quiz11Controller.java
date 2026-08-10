package com.app.controller.study.jstl.quiz.quiz11;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/quiz11")
public class Quiz11Controller {

	@GetMapping("/first")
	public String first(Model model, HttpSession session) {
//		if (session.getAttribute("accessUrl") != "/firsthide3") {
//			session.removeAttribute("hide3");
//		}

		if(session.getAttribute("accessUrl") == null) {
			model.addAttribute("accessUrl", "/first");
		}else {
//			model.addAttribute("accessUrl", "/firsthide3");
			model.addAttribute("accessUrl", session.getAttribute("accessUrl"));
			
			//session 영역 인식되는데 사용 완료 -> 삭제
//			session.invalidate();//세션 초기화
			session.removeAttribute("accessUrl");
		}
		

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

//	@GetMapping("/firsthide3")
//	public String firstHide3(HttpSession session) {
//		session.setAttribute("accessUrl", "/firsthide3");
//		session.setAttribute("hide3", "hide3");
//		return "redirect:/quiz11/first";
//	}

	@GetMapping("/firsthide3")
	public String firstHide3(Model model, HttpSession session, RedirectAttributes ra) {

//		model.addAttribute("accessUrl", "/firsthide3");
		
		//session 영역에 저장, firstHide3에 접속했다가 /first경로로 왔다
		
		session.setAttribute("accessUrl", "/firsthide3");
		
		ra.addFlashAttribute("fromhide3", "/firsthide3");
		
		
		return "redirect:/quiz11/first";
	}
}
