package com.cg.sprint.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Driver extends User{
	@Id
	private int driverId;
	private String licenceNO;
	@OneToOne
	private Cab cab;
	private float rating;
	@OneToMany
	private List<TripBooking> tripBooking;
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getLicenceNO() {
		return licenceNO;
	}
	public void setLicenceNO(String licenceNO) {
		this.licenceNO = licenceNO;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
}
