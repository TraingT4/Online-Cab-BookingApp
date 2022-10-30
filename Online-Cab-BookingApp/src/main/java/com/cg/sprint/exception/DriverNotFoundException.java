package com.cg.sprint.exception;

public class DriverNotFoundException extends RuntimeException{

	public DriverNotFoundException(String message) {
		super(message);
	}

	public DriverNotFoundException() {
		super();
	}

}