package com.cg.sprint.exception;

public class AdminNotFoundException extends RuntimeException{
	private String message;

	public AdminNotFoundException(String message) {
		super();
		this.message = message;
	}

	public AdminNotFoundException() {
		super();
	}
	
}
