package com.cg.sprint.exception;

public class CabNotFoundException extends RuntimeException{
	private String message;

	public CabNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CabNotFoundException() {
		super();
	}
}
