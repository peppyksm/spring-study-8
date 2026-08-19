package com.app.controller.study.rest;

import com.app.dto.api.ApiResponseHeader;

import lombok.Data;

@Data
public class ApiResponseDelevery {
	
	ApiResponseHeader header;
	ApiDelivery body;
	
}
