package com.cg.sprint.service;

import java.time.LocalDateTime;
import java.util.List;


import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.TripBooking;

public interface AdminService {
	Admin insertAdmin(Admin adm);
	Admin updateAdmin(Admin adm);
<<<<<<< HEAD
	void deleteAdmin(Long adminId);
    boolean validateAdmin(Admin adm);
=======
	void deleteAdmin(int adminId);
  
>>>>>>> 76abbb80cfa605372b42da3bb927491eae3c5750
	List<TripBooking> getAllTrips();
	List<TripBooking> getTripsCabwise(Long cabId);
	List<TripBooking> getTripsCustomerwise(Long customerId);
	List<TripBooking> getTripsDatewise(LocalDateTime date);
<<<<<<< HEAD
	List<TripBooking> getAllTripsForDays(Long customerId, LocalDateTime fromDate,LocalDateTime toDate);
=======
	List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate,LocalDateTime toDate);
	boolean validateAdmin(int adminId, String password);
>>>>>>> 76abbb80cfa605372b42da3bb927491eae3c5750
}
