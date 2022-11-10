package com.cg.sprint.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.CustomerNotFoundException;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.repository.TripBookingRepository;

@ExtendWith(MockitoExtension.class)
class TripBookingServiceTest {

	@InjectMocks
	private TripBookingServiceImpl tripBookingService;

	@Mock
	private TripBookingRepository tripBookingRepository;
	@Mock
	private CabRepository cabRepository;
	@Mock
	private CustomerRepository customerRepository;
	@Test
	void testInsertTripBooking() throws CustomerNotFoundException, CabNotFoundException {
		Optional<TripBooking>  trbOpt = getTripBookingMockData();
		TripBooking tripBooking= trbOpt.get();
		Mockito.when(cabRepository.findById(tripBooking.getCab().getCabId()).get()).thenReturn(tripBooking.getCab());
		Mockito.when(customerRepository.findById(tripBooking.getCustomer().getCustomerId()).get()).thenReturn(tripBooking.getCustomer());
		Mockito.when(tripBookingRepository.save(tripBooking)).thenReturn(tripBooking);
		TripBooking trb=tripBookingService.insertTripBooking(tripBooking, 101L, 100L);


		assertThat(trb.getToLocation().equals(tripBooking.getToLocation()));
	}

	@Test
	void updateTripBooking() throws CustomerNotFoundException, CabNotFoundException {
		Long tripBookingId=102l;
		Optional<TripBooking>  trbOpt = getTripBookingMockData();
		TripBooking tripBooking= trbOpt.get();
		Mockito.when(tripBookingRepository.findById(tripBookingId)).thenReturn(trbOpt);
		Mockito.when(tripBookingRepository.save(tripBooking)).thenReturn(tripBooking);
		TripBooking trb=tripBookingService.updateTripBooking(tripBooking, 101L, 100L);

		assertThat(trb.getToLocation().equals(tripBooking.getToLocation()));
	}

	@Test
	void deleteTripBooking() {
		Long tripBookingId=102l;
		Optional<TripBooking>  trbOpt = getTripBookingMockData();
		TripBooking tripBooking= trbOpt.get();
		Mockito.when(tripBookingRepository.findById(tripBookingId)).thenReturn(trbOpt);
		doNothing().when(tripBookingRepository).deleteById(tripBookingId);

		tripBookingService.deleteTripBooking(tripBookingId);
		assertThat(tripBooking.getFromLocation().equals("malda"));
	}

	private Optional<TripBooking> getTripBookingMockData() {
		TripBooking trb=new TripBooking();
		Customer cust=new Customer();
		cust.setCustomerId(100L);
		Cab cab=new Cab();
		cab.setCabId(101L);
		cab.setCarType("mini");
		trb.setTripBookingId(102L);
		//trb.setTripBookingId(102L);
	    trb.setCustomer(cust);
		trb.setCab(cab);
		//trb.setFromDateTime( LocalDateTime.of(2017, 2, 13, 15, 56));
		//trb.setToDateTime(LocalDateTime.of(2017, 2, 13, 15, 56));
		trb.setFromLocation("malda");
		trb.setToLocation("Kolkata");
		trb.setStatus(true);
		trb.setDistanceInKm(20f);
		trb.setBill(0f);
		return Optional.of(trb);
	}
}
