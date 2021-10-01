package com.example.restfulwebservices.controller;

//import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DateParseExceptionAdvice {

	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String badRequest(HttpMessageNotReadableException e) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("	\"error\": \""+e.getMessage()+"\"\n");
		sb.append("}");
		return sb.toString();
	}
}
