package com.cg.sprint.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.sprint.entity.Admin;

public interface AdminService {
	Admin saveAdmin(Admin adm);
	Admin updateAdmin(Admin adm);
	void deleteAdmin(int adminId);
	List<TripBooking> getAllTrips(int customerId);
	List<TripBooking> getTripsCabwise();
	List<TripBooking> getTripsCustomerwise();
	List<TripBooking> getTripsDatewise();
	List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate,LocalDateTime toDate);
}
