package com.cg.sprint.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.exception.AdminNotFoundException;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.CustomerNotFoundException;
import com.cg.sprint.exception.TripBookingNotFoundException;
import com.cg.sprint.repository.AdminRepository;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.repository.TripBookingRepository;
import com.cg.sprint.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	CabRepository cabRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TripBookingRepository tripBookingRepository;

	// insert admin method
	@Override
	public Admin insertAdmin(Admin adm) {
		adminRepository.save(adm);
		return adm;
	}

	// update admin method
	@Override
	public Admin updateAdmin(Admin adm) throws AdminNotFoundException {
		Admin admOpt = adminRepository.findByAdminId(adm.getAdminId());
		if (admOpt != null) {
			admOpt.setAdminId(adm.getAdminId());
			admOpt.setUsername(adm.getUsername());
			admOpt.setPassword(adm.getPassword());
			admOpt.setAddress(adm.getAddress());
			admOpt.setMobileNumber(adm.getMobileNumber());
			admOpt.setEmail(adm.getEmail());
			adminRepository.save(admOpt);
			return admOpt;
		} else {
			throw new AdminNotFoundException("No admin found with id: " + adm.getAdminId());
		}
	}

	// delete admin method
	@Override
	public void deleteAdmin(Long adminId) throws AdminNotFoundException {
		Optional<Admin> admOpt = adminRepository.findById(adminId);
		if (admOpt.isPresent()) {
			adminRepository.deleteById(adminId);
		} else {
			throw new AdminNotFoundException("No admin found with id: " + adminId);
		}
	}

	// get all trips method
	@Override
	public List<TripBooking> getAllTrips() {
		List<TripBooking> allTrips = tripBookingRepository.findAll();
		if (allTrips.isEmpty()) {
			throw new TripBookingNotFoundException("No trips booked");
		} else {
			return allTrips;
		}
	}

	// get trips using cab id
	@Override
	public List<TripBooking> getTripsCabwise(Long cabId) throws CabNotFoundException {
		Optional<Cab> cabOpt = cabRepository.findById(cabId);
		if (cabOpt.isPresent()) {
			List<TripBooking> tripList = tripBookingRepository.findTripByCabCabId(cabId);
			if (tripList.isEmpty()) {
				throw new TripBookingNotFoundException("No trips booked for cab: " + cabId);
				
			} else {
				return tripList;
			}
		} else {
			throw new CabNotFoundException("No cab found with id: " + cabId);
		}
	}

	// get trips using customer id
	@Override
	public List<TripBooking> getTripsCustomerwise(Long customerId) throws CustomerNotFoundException {
		Optional<Customer> custOpt = customerRepository.findById(customerId);
		if (custOpt.isPresent()) {
			List<TripBooking> custTrip = tripBookingRepository.findTripByCustomerCustomerId(customerId);
			if (custTrip.isEmpty()) {
				throw new TripBookingNotFoundException("No trips booked by customer: " + customerId);
			} else {
				return custTrip;
			}
		} else {
			throw new CustomerNotFoundException("No customer found with id: " + customerId);
		}
	}

	// get trips using date
		@Override
		public List<TripBooking> getTripsDatewise(LocalDateTime date) {
			List<TripBooking> tripDate = tripBookingRepository.findAll().stream()
					.filter(t -> t.getFromDateTime().getDayOfYear() == date.getDayOfYear()).toList();
			if (tripDate.isEmpty()) {
				String[] str = date.toString().split("T");
				throw new TripBookingNotFoundException("No trips booked for date: " + str[0]);
			} else {
				return tripDate;
			}
		}

		// get trips using customer id and between date
		@Override
		public List<TripBooking> getAllTripsForDays(Long customerId, LocalDateTime fromDate, LocalDateTime toDate) {
			Optional<Customer> custOpt = customerRepository.findById(customerId);
			if (custOpt.isPresent()) {
				List<TripBooking> tripDate = tripBookingRepository.findAll().stream()
						.filter(t -> t.getCustomer().getCustomerId().equals(customerId)
								&& (t.getFromDateTime().isAfter(fromDate) && t.getFromDateTime().isBefore(toDate)))
						.toList();
				if (tripDate.isEmpty()) {
					String[] str1 = fromDate.toString().split("T");
					String[] str2 = toDate.toString().split("T");
					throw new TripBookingNotFoundException(
							"No trips booked from " + str1[0] + " to " + str2[0] + " by customer " + customerId);
				} else {
					return tripDate;
				}
			} else {
				throw new CustomerNotFoundException("No customer found with id: " + customerId);
			}
		}

	@Override
	public String validateAdmin(Long adminid, String password) {
		Admin adminid1 = adminRepository.findUserByadminId(adminid);
		if (adminid1 != null && adminid1.getPassword().equals(password)) {

			return "Login Successful";

		} else {
			throw new AdminNotFoundException("Either admin id or password is incorrect");
		}

	}

	@Override
	public List<Admin> getAllAdmins() {
		
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(Long adminId) throws AdminNotFoundException{
		
		Admin admin=adminRepository.findByAdminId(adminId);
		if(admin!=null)
		{
			return admin;
		}
		else
		{
			throw new AdminNotFoundException("No admin found with id: " + adminId);
		}
		
	}

}
