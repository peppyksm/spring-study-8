package com.app.controller.study.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.utill.MyCookieUtil;

@Controller
public class Cookie02Controller {

	// 쿠키 활용 -> 아이디 기억

	@GetMapping("/idCookie")
	public String idCookie(HttpServletRequest request) {
		
		//페이지 요청 request에 쿠키값 확인
		//있으면? 아이디 기억 -> 화면에 기본값 표시
		//없다? 그냥 진행
		
		String remember = MyCookieUtil.getCookieValue(request, "remember");
		
		if(remember != null) {
			request.setAttribute("remember", remember);
		}else {
			
		}

		return "cookie/idCookie";
	}

	@PostMapping("/idCookie")
	public String idCookieAction(HttpServletRequest request, HttpServletResponse response) {
		// 로직처리
		// 입력 유효성 검증(필수 값 조건, 중복 등)
		// id pw <-> DB 데이터
		// 로그인 성공/실패 여부 판단 -> 성공? 성공페이지 이동
		// -> 실패? 로그엔페이지 이동

		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		System.out.println(request.getParameter("remember"));
		System.out.println("-------------------------------");
		// 체크박스 -> 치크 안하면 null, 체크하면 value 속성값 | value 속성 없으면 on

		// 로그인 성공으로 간주

		// 체크박스 역할 -> 아이디 기억 -> 체크O -> 쿠키에 아이디 저장

		String id = request.getParameter("id");
		String remember = request.getParameter("remember");

		if (remember == null) { // id기억 체크 X
			Cookie ck = MyCookieUtil.createCookieForRemove("remember");
			response.addCookie(ck);
			
		} else { // id기억 체크 O
			boolean isRemamber = Boolean.parseBoolean(remember);

			Cookie ck = MyCookieUtil.createCookie("remember", id, 60 * 60);
			response.addCookie(ck);
		}

		return "redirect:/readCookie";
	}

}
