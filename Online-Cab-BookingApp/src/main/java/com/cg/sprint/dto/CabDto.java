package com.cg.sprint.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.cg.sprint.entity.Driver;
import com.cg.sprint.entity.TripBooking;

public class CabDto {
	private Long cabId;
	@NotBlank(message="car type must not be empty")
	private String carType;
	@Positive(message="Rate per Km must be positive")
	private Float perKmRate;
	private Driver driver;
	private List<TripBooking> tripBooking;
	
	public CabDto() {
		super();
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
}
