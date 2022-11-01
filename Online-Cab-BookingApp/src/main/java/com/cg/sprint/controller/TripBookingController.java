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

import com.cg.sprint.dto.Convertor;
import com.cg.sprint.dto.TripBookingDto;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.CustomerNotFoundException;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.repository.TripBookingRepository;
import com.cg.sprint.service.TripBookingService;

@RestController
@RequestMapping("/api/tripbookings")
public class TripBookingController {

	@Autowired
	TripBookingService tripBookingService;
	@Autowired
	TripBookingRepository tripBookingRepository;
	@Autowired
	CabRepository cabRepository;
	@Autowired
	CustomerRepository customerRepository;
	Convertor convertor=new Convertor();

	@PostMapping("/{cab_id}/{customer_id}")
	public ResponseEntity<TripBooking> insertTripBooking(@RequestBody @Valid TripBookingDto trbDto,
			@PathVariable("cab_id") Long cabId, @PathVariable("customer_id") Long customerId) throws CustomerNotFoundException, CabNotFoundException {
		TripBooking trb=convertor.tripBookingEntitytoDto(trbDto);
		TripBooking tb = tripBookingService.insertTripBooking(trb, cabId, customerId);
		return new ResponseEntity<>(tb, HttpStatus.CREATED);
	}

	@PutMapping("/{cab_id}/{customer_id}")
	public ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBookingDto trbDto,
			@PathVariable("cab_id") Long cabId, @PathVariable("customer_id") Long customerId) throws CustomerNotFoundException, CabNotFoundException {
		TripBooking tripBooking=convertor.tripBookingEntitytoDto(trbDto);
		TripBooking tripBooking1 = tripBookingService.updateTripBooking(tripBooking, cabId, customerId);
		return new ResponseEntity<>(tripBooking1, HttpStatus.OK);
	}

	// delete admin using admin id
	@DeleteMapping("/{tripBooking_id}")
	public ResponseEntity<String> deleteTripBooking(@PathVariable("tripBooking_id") Long tripBookingId) {
		tripBookingService.deleteTripBooking(tripBookingId);
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{customer_id}")
	public ResponseEntity<List<TripBooking>> getTripBookingCustomerwise(@PathVariable("customer_id") Long customerId) {
		List<TripBooking> trips = tripBookingService.viewAllTripCustomer(customerId);
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}

	@GetMapping("/bill/{customer_id}")
	public ResponseEntity<List<TripBooking>> getTripBillCustomerwise(@PathVariable("customer_id") Long customerId) {
		List<TripBooking> trips = tripBookingService.calculateBill(customerId);
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}
	
//	@GetMapping("/bill/{customer_id}/{tripBooking_id}")
//	public ResponseEntity<TripBooking> getTripBillTripwise(@PathVariable("customer_id") Long customerId,@PathVariable("tripBooking_id") Long tripBookingId) {
//		TripBooking trip = tripBookingService.calculateTripBill(customerId,tripBookingId);
//		return new ResponseEntity<>(trip, HttpStatus.OK);
//	}

}
