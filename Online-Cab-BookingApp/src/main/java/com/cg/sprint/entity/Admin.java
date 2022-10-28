package com.cg.sprint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity
@Service
public class Admin extends User{
	@Id
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	
}
