package com.cg.sprint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cab {
	
	@Id
	private int cabId;
	private String carType;
	private float perKmRate;
	
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}

}
