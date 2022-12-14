package com.cg.sprint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Admin extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId;

	
	public Admin(Long adminId, String username, String password, String email, String mobile, String address) {
		setAdminId(adminId);
		setUsername(username);
		setAddress(address);
		setMobileNumber(mobile);
		setEmail(email);
		setPassword(password);
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Admin() {
		super();
	}

	
}
