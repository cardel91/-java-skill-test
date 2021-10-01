package com.example.restfulwebservices.controller;

public class PostNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PostNotFoundException(String id) {
		// TODO Auto-generated constructor stub
		super("Post with id: "+id+" not found!");
	}

}
