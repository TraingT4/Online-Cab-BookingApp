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
	
	//insert admin method
	@Override
	public Admin insertAdmin(Admin adm) {
		adminRepository.save(adm);
		return adm;
	}

	//update admin method
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
	
	
	//delete admin method
	@Override
	public void deleteAdmin(Long adminId) {
		adminRepository.deleteById(adminId);
	}
	
	//get all trips method
	@Override
	public List<TripBooking> getAllTrips() {
		return tripBookingRepository.findAll();
	}

	//get trips using cab id
	@Override
	public List<TripBooking> getTripsCabwise(Long cabId) {
		return tripBookingRepository.findTripByCabCabId(cabId);
	}

	//get trips using customer id
	@Override
	public List<TripBooking> getTripsCustomerwise(Long customerId) {
		return tripBookingRepository.findTripByCustomerCustomerId(customerId);
	}

	//get trips using date
	@Override
	public List<TripBooking> getTripsDatewise(LocalDateTime date) {
		return tripBookingRepository.findAll().stream().filter(t->t.getFromDateTime().getDayOfYear()==date.getDayOfYear()).toList();
	}

	//get trips using customer id and between date
	@Override
	public List<TripBooking> getAllTripsForDays(Long customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		return tripBookingRepository.findAll().stream().filter(t->t.getCustomer().getCustomerId().equals(customerId) && (t.getFromDateTime().isAfter(fromDate)&&t.getFromDateTime().isBefore(toDate))).toList();
	}

	@Override
	public boolean validateAdmin(Admin admin) {
		Admin adminid = adminRepository.findUserByadminId(admin.getAdminId());
		
        if(adminid.getAdminId().equals(adminid.getAdminId())&&adminid.getPassword().equals(admin.getPassword())) {
        	
              return true;
        }
        return false;

   
	}

}
