package com.cg.sprint.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Customer;

public class TripBookingDto {

	private Long tripBookingId;
	private Customer customer;
	private Cab cab;
	@NotNull(message = "fromLocation should not be null")
	private String fromLocation;
	@NotNull(message = "toLocation should not be null")
	private String toLocation;
	@NotNull(message = "fromDateTime should not be null")
	private LocalDateTime fromDateTime;
	@NotNull(message = "toDateTime should not be null")
	private LocalDateTime toDateTime;
	private Boolean status;
	@Positive(message = "distance should be Positive")
	private Float distanceInKm;
	private Float bill;
	public Long getTripBookingId() {
		return tripBookingId;
	}
	public void setTripBookingId(Long tripBookingId) {
		this.tripBookingId = tripBookingId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(Float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public Float getBill() {
		return bill;
	}
	public void setBill(Float bill) {
		this.bill = bill;
	}
	
}
