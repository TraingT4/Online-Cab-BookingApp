package com.cg.sprint.exception;

public class AdminNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNotFoundException(String message) {
		super(message);
	}
}
