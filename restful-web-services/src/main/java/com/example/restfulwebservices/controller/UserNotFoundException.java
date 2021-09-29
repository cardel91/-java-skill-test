package com.example.restfulwebservices.controller;


public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
		// TODO Auto-generated constructor stub
		super("User with id: "+id+" not found!");
	}
}
