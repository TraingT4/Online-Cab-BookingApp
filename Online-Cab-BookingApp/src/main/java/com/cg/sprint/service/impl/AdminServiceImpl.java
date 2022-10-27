package com.cg.sprint.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.repository.AdminRepository;
import com.cg.sprint.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin insertAdmin(Admin adm) {
		adminRepository.save(adm);
		return adm;
	}

	@Override
	public Admin updateAdmin(Admin adm) {
		
		adminRepository.save(adm);

		return adm;
	}

	@Override
	public void deleteAdmin(int adminId) {
		Admin ad=adminRepository.getOne(adminId);
		adminRepository.delete(ad);
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		return null;
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		return null;
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		return null;
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		return null;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		return null;
	}

}
