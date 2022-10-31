package com.cg.sprint.dto;


import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.Driver;
import com.cg.sprint.entity.TripBooking;

public class Convertor {

	public Cab cabDtoToEntity(CabDto cabDto)
	{
		Cab cab=new Cab();
		cab.setCabId(cabDto.getCabId());
		cab.setCarType(cabDto.getCarType());
		cab.setDriver(cabDto.getDriver());
		cab.setPerKmRate(cabDto.getPerKmRate());
		cab.setTripBooking(cabDto.getTripBooking());
		return cab;
	}
	
	public Admin adminDtoToEntity(AdminDto adminDto) 
	{
		Admin admin=new Admin();
		admin.setAdminId(adminDto.getAdminId());
		admin.setAddress(adminDto.getAddress());
		admin.setEmail(adminDto.getEmail());
		admin.setMobileNumber(adminDto.getMobileNumber());
		admin.setPassword(adminDto.getPassword());
		admin.setUsername(adminDto.getUsername());
		return admin;
	}
	
	public Customer customerEntitytoDto(CustomerDto customerDto) 
	{
		Customer customer=new Customer();
		customer.setAddress(customerDto.getAddress());
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setPassword(customerDto.getPassword());
		customer.setTripBooking(customerDto.getTripBooking());
		customer.setUsername(customerDto.getUsername());
		return customer;
	}
	
	public Driver driverEntitytoDto(DriverDto driverDto)
	{
		Driver driver=new Driver();
		driver.setAddress(driverDto.getAddress());
		driver.setCab(driverDto.getCab());
		driver.setDriverId(driverDto.getDriverId());
		driver.setEmail(driverDto.getEmail());
		driver.setLicenceNO(driverDto.getLicenceNO());
		driver.setMobileNumber(driverDto.getMobileNumber());
		driver.setPassword(driverDto.getPassword());
		driver.setRating(driverDto.getRating());
		driver.setUsername(driverDto.getUsername());
		return driver;
	}
	
	public TripBooking tripBookingEntitytoDto(TripBookingDto tripBookingDto)
	{
		TripBooking tripBooking= new TripBooking();
		tripBooking.setBill(tripBookingDto.getBill());
		tripBooking.setCab(tripBookingDto.getCab());
		tripBooking.setCustomer(tripBookingDto.getCustomer());
		tripBooking.setDistanceInKm(tripBookingDto.getDistanceInKm());
		tripBooking.setFromDateTime(tripBookingDto.getFromDateTime());
		tripBooking.setFromLocation(tripBookingDto.getFromLocation());
		tripBooking.setStatus(tripBookingDto.getStatus());
		tripBooking.setToDateTime(tripBookingDto.getToDateTime());
		tripBooking.setToLocation(tripBookingDto.getToLocation());
		tripBooking.setTripBookingId(tripBookingDto.getTripBookingId());
		
		return tripBooking;
	}
}
