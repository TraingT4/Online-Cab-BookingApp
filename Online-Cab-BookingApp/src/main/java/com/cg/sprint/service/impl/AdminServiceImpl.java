package com.cg.sprint.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.repository.AdminRepository;
import com.cg.sprint.repository.TripBookingRepository;
import com.cg.sprint.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	TripBookingRepository tripBookingRepository;
	@Autowired
	Admin admin;

	// insert admin method
	@Override
	public Admin insertAdmin(Admin adm) {
		adminRepository.save(adm);
		return adm;
	}

	// update admin method
	@Override
	public Admin updateAdmin(Admin adm) {
		Optional<Admin> admOpt = adminRepository.findById(adm.getAdminId());
		Admin adm1 = null;
		adm1 = admOpt.get();
		adm1.setAdminId(adm.getAdminId());
		adm1.setUsername(adm.getUsername());
		adm1.setPassword(adm.getPassword());
		adm1.setAddress(adm.getAddress());
		adm1.setMobileNumber(adm.getMobileNumber());
		adm1.setEmail(adm.getEmail());
		adminRepository.save(adm1);

		return adm1;
	}

	// delete admin method
	@Override
	public void deleteAdmin(int adminId) {
		adminRepository.deleteById(adminId);
	}

	// get all trips method
	@Override
	public List<TripBooking> getAllTrips() {
		return tripBookingRepository.findAll();
	}

	// get trips using cab id
	@Override
	public List<TripBooking> getTripsCabwise(int cabId) {
		return tripBookingRepository.findAll().stream().filter(t -> t.getDriver().getCab().getCabId() == cabId)
				.toList();
	}

	// get trips using customer id
	@Override
	public List<TripBooking> getTripsCustomerwise(int customerId) {
		return tripBookingRepository.findAll().stream().filter(t -> t.getCustomer().getCustomerId() == customerId)
				.toList();
	}

	// get trips using date
	@Override
	public List<TripBooking> getTripsDatewise(LocalDateTime date) {
		return tripBookingRepository.findAll().stream().filter(t -> t.getFromDateTime().equals(date)).toList();
	}

	// get trips using customer id and between date
	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		return tripBookingRepository.findAll().stream().filter(t -> t.getCustomer().getCustomerId() == customerId
				&& (t.getFromDateTime().isAfter(fromDate) && t.getFromDateTime().isBefore(toDate))).toList();
	}

	@Override
	public boolean validateAdmin(int adminid,String password) {
		Admin adminid1 = adminRepository.findUserByadminId(adminid);

		try {
			if (adminid1.getAdminId() == adminid && adminid1.getPassword().equals(password)) {

				return true;
				

			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			return false;
		}

	}

}
