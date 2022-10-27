package com.cg.sprint.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class TripBooking {
	
	@Id
	private int tripBookingId;
	@OneToOne
	private Customer customer;
	@ManyToOne(targetEntity = Driver.class)
	private Driver driver;
	private String fromLoccation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
	
	
}
