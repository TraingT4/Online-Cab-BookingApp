package com.cg.sprint.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Cab {
	
	@Id
	private Long cabId;
	private String carType;
	private Float perKmRate;
	@OneToOne
	private Driver driver;
	@OneToMany
	private List<TripBooking> tripBooking;
	
	
	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}
	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}
	public Long getCabId() {
		return cabId;
	}
	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public Float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(Float perKmRate) {
		this.perKmRate = perKmRate;
	}

}
