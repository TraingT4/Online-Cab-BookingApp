package com.cg.sprint.exception;

public class TripBookingNotFoundException extends RuntimeException{

	public TripBookingNotFoundException(String message) {
		super(message);
	}
	public TripBookingNotFoundException() {
		super();
	}

}
