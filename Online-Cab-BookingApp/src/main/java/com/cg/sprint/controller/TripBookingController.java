package com.cg.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.service.TripBookingService;

@RestController
@RequestMapping("/api/tripbooking")
public class TripBookingController {
	
	@Autowired
	TripBookingService tripBookingService;
	
	
	@PostMapping("/")
	public ResponseEntity<TripBooking> insertTripBooking(@RequestBody @Valid TripBooking trb) {
		TripBooking ad = tripBookingService.insertTripBooking(trb);
		ResponseEntity<TripBooking> response = new ResponseEntity<TripBooking>(ad, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/")
	public ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBooking tripBooking) {
		TripBooking tripBooking1 = tripBookingService.updateTripBooking(tripBooking);
		ResponseEntity<TripBooking> reponse = new ResponseEntity<TripBooking>(tripBooking1, HttpStatus.OK);
		return reponse;
	}
	
	// delete admin using admin id
		@DeleteMapping("/{tripBooking_id}")
		public ResponseEntity<String> deleteTripBooking(@PathVariable("tripBooking_id") String tripBookingId1) {
			int tripBookingId = Integer.parseInt(tripBookingId1);
			tripBookingService.deleteTripBooking(tripBookingId);
			ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
			return response;
		}
		
		@GetMapping("/{customer_id}")
		public ResponseEntity<List<TripBooking>> getTripBookingCustomerwise(@PathVariable("customer_id") String customerId) {
			int cid = Integer.parseInt(customerId);
			List<TripBooking> trips = tripBookingService.viewAllTripCustomer(cid);
			ResponseEntity<List<TripBooking>> response = new ResponseEntity<>(trips, HttpStatus.OK);
			return response;
		}
		
		@GetMapping("/bill/{customer_id}")
		public ResponseEntity <TripBooking>getTripBillCustomerwise(@PathVariable("customer_id") String customerId) {
			int cid = Integer.parseInt(customerId);
			TripBooking trips = tripBookingService.calculateBill(cid);
			ResponseEntity<TripBooking> response = new ResponseEntity<>(trips, HttpStatus.OK);
			return response;
		}

}
