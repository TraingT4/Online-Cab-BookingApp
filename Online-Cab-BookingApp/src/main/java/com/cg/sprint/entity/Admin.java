package com.cg.sprint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity
@Service
public class Admin extends User{
	@Id
	private Long adminId;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	
}
