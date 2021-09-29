package com.example.restfulwebservices.controller;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DateParseExceptionAdvice {

	@ResponseBody
	@ExceptionHandler(ParseException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String badRequest(ParseException e) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("	\"error\": \""+e.getMessage()+"\"\n");
		sb.append("}");
		return sb.toString();
	}
}
