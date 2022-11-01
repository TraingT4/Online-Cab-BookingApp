package com.cg.sprint.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.CustomerNotFoundException;
import com.cg.sprint.exception.TripBookingNotFoundException;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.repository.TripBookingRepository;
import com.cg.sprint.service.TripBookingService;

@Service
public class TripBookingServiceImpl implements TripBookingService {

	@Autowired
	TripBookingRepository tripBookingRepository;
	@Autowired
	CabRepository cabRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	String custexcp="No customer found with id: ";
	String cabexcp="No cab found with id: ";

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking, Long cabId, Long customerId)
			throws CustomerNotFoundException, CabNotFoundException {
		Optional<Cab> cabOpt = cabRepository.findById(cabId);
		if (cabOpt.isPresent()) {
			Cab cab = cabOpt.get();
			Optional<Customer> customerOpt = customerRepository.findById(customerId);
			if (customerOpt.isPresent()) {
				Customer customer = customerOpt.get();
				tripBooking.setCustomer(customer);
				tripBooking.setCab(cab);
				tripBooking.setBill((tripBooking.getDistanceInKm()) * (tripBooking.getCab().getPerKmRate()));
				tripBookingRepository.save(tripBooking);
				return tripBooking;
			} else {
				throw new CustomerNotFoundException(custexcp+customerId);
			}
		} else {
			throw new CabNotFoundException(cabexcp+cabId);
		}
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking, Long cabId, Long customerId)
			throws CabNotFoundException, CustomerNotFoundException {

		Optional<TripBooking> trpbkOpt = tripBookingRepository.findById(tripBooking.getTripBookingId());
		TripBooking tripBooking1 = null;
		if (trpbkOpt.isPresent()) {
			tripBooking1 = trpbkOpt.get();
			Optional<Cab> cabOpt = cabRepository.findById(cabId);
			if (cabOpt.isPresent()) {
				Cab cab = cabOpt.get();
				Optional<Customer> customerOpt = customerRepository.findById(customerId);
				if (customerOpt.isPresent()) {
					Customer customer = customerOpt.get();
					tripBooking1.setCustomer(customer);
					tripBooking1.setCab(cab);
					tripBooking1.setTripBookingId(tripBooking.getTripBookingId());
					tripBooking1.setFromLocation(tripBooking.getFromLocation());
					tripBooking1.setToLocation(tripBooking.getToLocation());
					tripBooking1.setFromDateTime(tripBooking.getFromDateTime());
					tripBooking1.setToDateTime(tripBooking.getToDateTime());
					tripBooking1.setStatus(tripBooking.isStatus());
					tripBooking1.setDistanceInKm(tripBooking.getDistanceInKm());
					tripBooking1.setBill(tripBooking.getBill());
					tripBookingRepository.save(tripBooking1);
					return tripBooking1;
				} else {
					throw new CustomerNotFoundException(custexcp+customerId);
				}
			} else {
				throw new CabNotFoundException(cabexcp+cabId);
			}
		} else {
			throw new TripBookingNotFoundException("No trip booking found with id: "+tripBooking.getTripBookingId());
		}
	}

	@Override
	public TripBooking deleteTripBooking(Long tripBookingId) throws TripBookingNotFoundException {
		Optional<TripBooking> trpbkOpt = tripBookingRepository.findById(tripBookingId);
		if (trpbkOpt.isPresent()) {
			tripBookingRepository.deleteById(tripBookingId);
			return null;
		} else {
			throw new TripBookingNotFoundException("No trip booking found with id: "+tripBookingId);
		}
	}

	@Override
	public List<TripBooking> viewAllTripCustomer(Long customerId) throws CustomerNotFoundException{
		Optional<Customer> customerOpt = customerRepository.findById(customerId);
		if (customerOpt.isPresent()) {
		return tripBookingRepository.findAll().stream().filter(t -> t.getCustomer().getCustomerId().equals(customerId))
				.toList();
		}else {
			throw new CustomerNotFoundException(custexcp+customerId);
		}
	}

	@Override
	public List<TripBooking>calculateBill(Long customerId) {
		List<TripBooking> trip1 = tripBookingRepository.findAll();
		List<TripBooking> trip2 = new ArrayList<>();
		for (TripBooking tripop : trip1) {
			if (tripop.getCustomer().getCustomerId().equals(customerId)) {
				tripop.setBill((tripop.getDistanceInKm()) * (tripop.getCab().getPerKmRate()));
				trip2.add(tripop);
			}
		}
		return trip2;
	}
	
//	@Override
//	public TripBooking calculateTripBill(Long customerId, Long tripBookingId) {
//		Optional<Customer> customerOpt = customerRepository.findById(customerId);
//		if (customerOpt.isPresent()) {
//			Optional<List<TripBooking>> trpbkOpt = tripBookingRepository.findTripByCustomerCustomerId(customerId);
//			if(trpbkOpt.)
//			if (trpbkOpt.isPresent()) {
//			for (TripBooking tripop : trip1) {
//				if (tripop.getCustomer().getCustomerId().equals(customerId)) {
//					tripop.setBill((tripop.getDistanceInKm()) * (tripop.getCab().getPerKmRate()));
//					trip2.add(tripop);
//				}
//		}
//		
//		}
//		return trip2;
//	}

}
