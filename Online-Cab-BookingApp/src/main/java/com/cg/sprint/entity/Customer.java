package com.cg.sprint.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Customer extends User{
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	
	@OneToMany(mappedBy = "customer")
	private List<TripBooking> tripBooking;
	
	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public Customer(Long customerId, String username, String password, String email, String mobile, String address) {
		setCustomerId(customerId);
		setUsername(username);
		setAddress(address);
		setMobileNumber(mobile);
		setEmail(email);
		setPassword(password);
	}

	public Customer() {
		super();
	}
}
