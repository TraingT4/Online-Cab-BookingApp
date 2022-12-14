package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.CustomerNotFoundException;
import com.cg.sprint.exception.TripBookingNotFoundException;

public interface TripBookingService {

	TripBooking insertTripBooking(TripBooking tripBooking, Long cabId, Long customerId)
			throws CustomerNotFoundException, CabNotFoundException;

	TripBooking updateTripBooking(TripBooking tripBooking, Long cabId, Long customerId)
			throws CabNotFoundException, CustomerNotFoundException;

	TripBooking deleteTripBooking(Long tripBookingId);

	List<TripBooking> viewAllTripCustomer(Long customerId) throws CustomerNotFoundException;
	List<TripBooking> viewAllTrip() throws TripBookingNotFoundException;

	List<TripBooking> calculateBill(Long customerId);

	TripBooking calculateTripBill(Long tripBookingId);

	TripBooking findTrips(Long tripbooking_id)throws TripBookingNotFoundException;
}
