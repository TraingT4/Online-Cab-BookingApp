package com.cg.sprint.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.cg.sprint.entity.Cab;

public class DriverDto {
	
	private Long driverId;
	@NotBlank(message = "Licence Number must not be null")
	private String licenceNO;
	@NotNull(message = "Rating must not be null")
	private Float rating;
	private Cab cab;
	@NotNull
	private String username;
	@NotNull
	private String password;

	@Pattern(regexp = "^\\w+@\\w+.[a-zA-Z]+")

	@Pattern(regexp = "^\\w+@\\w+.[a-zA-Z]+",message = "Email should be of patter: abc123@abc.com")
	private String email;
	@Pattern(regexp = "\\d{10}",message = "Mobile number should be 10 digits")
	@Positive
	private String mobileNumber;
	@NotNull
	private String address;
	
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
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public String getLicenceNO() {
		return licenceNO;
	}
	public void setLicenceNO(String licenceNO) {
		this.licenceNO = licenceNO;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	
}
