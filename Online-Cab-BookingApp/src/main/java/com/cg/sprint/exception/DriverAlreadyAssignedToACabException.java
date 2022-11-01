package com.cg.sprint.exception;

public class DriverAlreadyAssignedToACabException extends RuntimeException {
	public DriverAlreadyAssignedToACabException(String message) {
		super(message);
	}

	public DriverAlreadyAssignedToACabException() {
		super();
	}
}
