package com.cg.sprint.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.dto.AdminDto;
import com.cg.sprint.dto.Convertor;
import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.service.AdminService;
import com.cg.sprint.service.TripBookingService;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	TripBookingService tripBookingService;

	Convertor convertor=new Convertor();
	// inserting the admin
	@PostMapping("/")
	public ResponseEntity<Admin> insertAdmin(@RequestBody @Valid AdminDto adminDto) {
		Admin admin=convertor.adminDtoToEntity(adminDto);
		Admin ad = adminService.insertAdmin(admin);
		return new ResponseEntity<>(ad, HttpStatus.CREATED);
	}

	// update the admin
	@PutMapping("/")
	public ResponseEntity<Admin> updateAdmin(@RequestBody @Valid AdminDto adminDto) {
		Admin admin=convertor.adminDtoToEntity(adminDto);
		Admin adm = adminService.updateAdmin(admin);
		return new ResponseEntity<>(adm, HttpStatus.OK);
	}

	// delete admin using admin id
	@DeleteMapping("/{admin_id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("admin_id") Long adminId) {
		adminService.deleteAdmin(adminId);
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/")
	public ResponseEntity<List<Admin>> getallAdmins() {
		List<Admin> admins = adminService.getAllAdmins();
		return new ResponseEntity<>(admins, HttpStatus.OK);
	}
	// get all trips method
	@GetMapping("/trips")
	public ResponseEntity<List<TripBooking>> getallTrips() {
		List<TripBooking> trips = adminService.getAllTrips();
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}

	// get all trips method
	@GetMapping("/trips/customers/{customer_id}")
	public ResponseEntity<List<TripBooking>> getTripsCustomerwise(@PathVariable("customer_id") Long customerId) {
		List<TripBooking> trips = adminService.getTripsCustomerwise(customerId);
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}

	// get trips using cab id method
	@GetMapping("/trips/cab/{cab_id}")
	public ResponseEntity<List<TripBooking>> getTripsCabwise(@PathVariable("cab_id") Long cabId) throws CabNotFoundException {
		List<TripBooking> trips = adminService.getTripsCabwise(cabId);
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}
	
	//get trips for a date
	@GetMapping("/trips/{date}")
	public ResponseEntity<List<TripBooking>> getTripsDatewise(@PathVariable("date") String date) {
		date=date+"T00:00:00.000";
		LocalDateTime dt=LocalDateTime.parse(date);
		List<TripBooking> trips = adminService.getTripsDatewise(dt);
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}
	
	//get all trips using customer id, from date and to date
	@GetMapping("/trips/customers/{customer_id}/{from_date}/{to_date}")
	public ResponseEntity<List<TripBooking>> getAllTripsForDays(@PathVariable("customer_id") Long customerId,@PathVariable("from_date") String fromDate,@PathVariable("to_date") String toDate) {
		fromDate=fromDate+"T00:00:00.000";
		toDate=toDate+"T00:00:00.000";
		LocalDateTime fdt=LocalDateTime.parse(fromDate);
		LocalDateTime tdt=LocalDateTime.parse(toDate);
		List<TripBooking> trips = adminService.getAllTripsForDays(customerId, fdt, tdt);
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}
}
