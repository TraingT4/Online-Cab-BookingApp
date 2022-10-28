package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.entity.TripBooking;

public interface TripBookingService {
 
	TripBooking insertTripBooking(TripBooking tripBooking);
	TripBooking updateTripBooking(TripBooking tripBooking);
	TripBooking deleteTripBooking(int tripBookingId);
	List<TripBooking> viewAllTripCustomer(int customerId);
	TripBooking calculateBill(int customerId);
}
