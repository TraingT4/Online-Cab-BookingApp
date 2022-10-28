package com.cg.sprint.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.repository.TripBookingRepository;
import com.cg.sprint.service.TripBookingService;

@Service
public class TripBookingServiceImpl implements TripBookingService {

	@Autowired
	TripBookingRepository tripBookingRepository;
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		tripBookingRepository.save(tripBooking);
		return tripBooking;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		Optional<TripBooking> trpbkOpt =  tripBookingRepository.findById(tripBooking.getTripBookingId());
		TripBooking tripBooking1=null;
		
		tripBooking1=trpbkOpt.get();
		tripBooking1.setTripBookingId(tripBooking.getTripBookingId());
		tripBooking1.setCustomer(tripBooking.getCustomer());
		tripBooking1.setDriver(tripBooking.getDriver());
		tripBooking1.setFromLocation(tripBooking.getFromLocation());
		tripBooking1.setToLocation(tripBooking.getToLocation());
		tripBooking1.setFromDateTime(tripBooking.getFromDateTime());
		tripBooking1.setToDateTime(tripBooking.getToDateTime());
		tripBooking1.setStatus(tripBooking.isStatus());
		tripBooking1.setDistanceInKm(tripBooking.getDistanceInKm());
		tripBooking1.setBill(tripBooking.getBill());
		tripBookingRepository.save(tripBooking1);
		return tripBooking1;
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) {
		tripBookingRepository.deleteById(tripBookingId);
		return null;
	}

	@Override
	public List<TripBooking> viewAllTripCustomer(int customerId) {
		
		return tripBookingRepository.findAll().stream().filter(t->t.getCustomer().getCustomerId()==customerId).toList();                       
	}

	@Override
	public TripBooking calculateBill(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
