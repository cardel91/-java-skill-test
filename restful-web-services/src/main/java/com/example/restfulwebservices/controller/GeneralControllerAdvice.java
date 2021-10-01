package com.example.restfulwebservices.controller;


import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.restfulwebservices.model.Model;

@RestControllerAdvice
public class GeneralControllerAdvice  {

	/*
	 * Your method handleMethodArgumentNotValidException is also annotated to handle MethodArgumentNotValidException. 
	 * So spring finds two methods that should be used to handle the same exception, that is the reason for the exception.
	 * **Solution ** Do not add a new method handleMethodArgumentNotValidException instead just override the method 
	 * ResponseEntityExceptionHandler.handleMethodArgumentNotValid, and do not annotate it. 
	 * Your class ErrorWrapper must extend ResponseEntity for that.
	 */
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<JsonResponse> handleInvalidDataException(
			MethodArgumentNotValidException ex, WebRequest request) {
	
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<JsonResponse>(new JsonResponse(ex.getMessage()), headers, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<JsonResponse> handleEntityNotFoundException(
			EntityNotFoundException ex, WebRequest request) {
	
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<JsonResponse>(new JsonResponse(ex.getMessage()), headers, HttpStatus.BAD_REQUEST);
	}
	
	
	private class JsonResponse {
        String message;

        public JsonResponse() {
        }

        public JsonResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }       
    }
}
