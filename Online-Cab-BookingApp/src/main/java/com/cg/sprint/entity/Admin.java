package com.cg.sprint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
