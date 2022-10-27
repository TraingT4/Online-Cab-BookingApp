package com.cg.sprint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer extends User{
	@Id
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
