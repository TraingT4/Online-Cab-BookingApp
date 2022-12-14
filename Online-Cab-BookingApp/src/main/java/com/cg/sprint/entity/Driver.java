package com.cg.sprint.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Driver extends User {
	@Id
	@Column(name = "driver_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long driverId;
	@NotBlank(message = "Licence Number must not be null")
	private String licenceNO;
	@NotNull(message = "Rating must not be null")
	private Float rating;

	@OneToOne(mappedBy = "driver")
	@JsonBackReference
	@JoinColumn(name = "cab_id")
	private Cab cab;
	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getLicenceNO() {
		return licenceNO;
	}

	public void setLicenceNO(String licenceNO) {
		this.licenceNO = licenceNO;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Driver() {
		super();
	}

	public Driver(Long driverId, @NotBlank(message = "Licence Number must not be null") String licenceNO,
			@NotNull(message = "Rating must not be null") Float rating) {
		super();
		this.driverId = driverId;
		this.licenceNO = licenceNO;
		this.rating = rating;
	}

}
