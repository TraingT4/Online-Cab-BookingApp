package com.cg.sprint.service;

import java.time.LocalDateTime;
import java.util.List;


import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.TripBooking;

public interface AdminService {
	Admin insertAdmin(Admin adm);
	Admin updateAdmin(Admin adm);
	void deleteAdmin(int adminId);
  
	List<TripBooking> getAllTrips();
	List<TripBooking> getTripsCabwise(int cabId);
	List<TripBooking> getTripsCustomerwise(int customerId);
	List<TripBooking> getTripsDatewise(LocalDateTime date);
	List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate,LocalDateTime toDate);
	boolean validateAdmin(int adminId, String password);
}
