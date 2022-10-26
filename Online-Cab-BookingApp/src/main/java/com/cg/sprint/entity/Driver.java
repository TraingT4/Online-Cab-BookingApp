package com.cg.sprint.entity;
public class Driver extends User{

	private int driverId;
	private String licenceNO;
	private Cab cab;
	private float rating;
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
