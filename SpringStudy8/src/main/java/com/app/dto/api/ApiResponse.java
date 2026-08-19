package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponse<T> {
	//Generic 타입을 고정하지 않고 사용방식 일반화
	
	ApiResponseHeader header;
	T body;
	
}
