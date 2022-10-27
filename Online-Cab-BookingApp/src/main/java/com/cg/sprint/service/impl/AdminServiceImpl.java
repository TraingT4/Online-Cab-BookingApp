package com.cg.sprint.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.repository.AdminRepository;
import com.cg.sprint.service.AdminService;
import com.cg.sprint.service.TripBooking;

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
		Optional<Admin> admOpt = adminRepository.findById(adm.getAdminId());
		Admin adm1 = null;
		adm1 = admOpt.get();
		adm1.setUsername(adm.getUsername());
		adm1.setPassword(adm.getPassword());
		adm1.setAddress(adm.getAddress());
		adm1.setMobileNumber(adm.getMobileNumber());
		adm1.setEmail(adm.getEmail());
		adminRepository.save(adm1);

		return adm1;
	}

	@Override
	public void deleteAdmin(int adminId) {
		adminRepository.deleteById(adminId);
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
