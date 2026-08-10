package com.app.controller.study.jstl.quiz.quiz07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //전체 파라미터 생성자
@NoArgsConstructor	//파라미터x 생성자
@Data				//getter setter toString 자동생성
public class Member {
	String id;
	String pw;
	String name;
}