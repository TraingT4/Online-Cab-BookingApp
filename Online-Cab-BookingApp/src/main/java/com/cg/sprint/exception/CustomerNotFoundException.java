package com.cg.sprint.exception;

public class CustomerNotFoundException extends RuntimeException{
	private String message;

	public CustomerNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CustomerNotFoundException() {
		super();
	}
}
