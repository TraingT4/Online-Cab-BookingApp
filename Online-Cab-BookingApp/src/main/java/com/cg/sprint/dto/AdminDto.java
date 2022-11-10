package com.cg.sprint.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class AdminDto {
	
	private Long adminId;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@Pattern(regexp = "^\\w+@\\w+.[a-zA-Z]+",message = "Email should be of patter: abc123@abc.com")
	private String email;
	@Pattern(regexp = "\\d{10}",message = "Mobile number should be 10 digits")
	@Positive
	private String mobileNumber;
	@NotNull
	private String address;
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
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
