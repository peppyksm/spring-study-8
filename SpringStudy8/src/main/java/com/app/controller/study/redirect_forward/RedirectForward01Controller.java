package com.app.controller.study.redirect_forward;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/re")
public class RedirectForward01Controller {
	
	@GetMapping("/re1")
	public String re1() {
		return "re/re1";
	}
	
	@GetMapping("/re2")
	public String re2(HttpServletRequest request) {
		
		System.out.println("/re2");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re2";
		
	}
	
	@GetMapping("/re3")
	public String re3(HttpServletRequest request) {
		
		System.out.println("/re2");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re2"; //요청 re3 -> 응답 re2 페이지
		
	}
	
	@GetMapping("/re4")
	public String re4(HttpServletRequest request) {
		
		System.out.println("/re4");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re4"; //요청 re4 -> 응답 re4 페이지 -> (re4 view) 코드 경로 이동
		
	}
	
	@GetMapping("/re5")
	public String re5(HttpServletRequest request) {
		
		System.out.println("/re5");
		System.out.println(request.getParameter("msg"));
		
		return "redirect:/re/re2";
		//redirect:요청할이동경로
		//redirect return이 화면 view 이름을 나타내느것이 아님
		
		//return view이름  /WEB-INF/views/	+	re/re2	+	.jsp
		//return redirect:주소이름			localhost:8080	/re/re2	주소창에 들어갈 값(경로)
													//	인터넷주소창 or GetMapping("경로")
		
	}
	
	@GetMapping("/re6")
	public String re6(HttpServletRequest request) {
		
		//server 에서 forward 자리
		System.out.println("/re6");
		System.out.println(request.getParameter("msg"));
		
		//forward 서버에서 바로 요청 경로를 이동해서 수행
		return "forward:/re/re2";
		//forward:주소요청경로 GetMapping("경로)
		
	}
	
}
