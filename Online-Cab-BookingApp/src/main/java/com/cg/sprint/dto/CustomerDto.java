package com.cg.sprint.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.cg.sprint.entity.TripBooking;

public class CustomerDto {
	private Long customerId;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@Pattern(regexp = "^\\w+@\\w+.[a-zA-Z]+")
	private String email;
	@Pattern(regexp = "\\d{10}",message = "Mobile number should be 10 digits")
	@Positive
	private String mobileNumber;
	@NotNull
	private String address;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
