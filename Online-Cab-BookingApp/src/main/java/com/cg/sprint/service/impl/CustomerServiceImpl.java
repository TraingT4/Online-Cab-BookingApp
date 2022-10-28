package com.cg.sprint.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	// insert customer method
	@Override
	public Customer insertCustomer(Customer cust) {
		customerRepository.save(cust);
		return cust;
	}

	// update customer method
	@Override
	public Customer updateCustomer(Customer cust) {
		Optional<Customer> cusOpt = customerRepository.findById(cust.getCustomerId());
		Customer cust1 = null;
		cust1 = cusOpt.get();
		cust1.setCustomerId(cust.getCustomerId());
		cust1.setUsername(cust.getUsername());
		cust1.setPassword(cust.getPassword());
		cust1.setAddress(cust.getAddress());
		cust1.setMobileNumber(cust.getMobileNumber());
		cust1.setEmail(cust.getEmail());
		customerRepository.save(cust1);

		return cust1;
	}

	// delete customer using customer id method
	@Override
	public void deleteCustomer(Long customerId) {
		customerRepository.deleteById(customerId);
	}

	// view all customers method
	@Override
	public List<Customer> viewCustomers() {
		return customerRepository.findAll();
	}

	// view customer using customer id method
	@Override
<<<<<<< HEAD
	public Customer viewCustomer(Long customerId) {
=======
	public Customer viewCustomer(int customerId) {
>>>>>>> 76abbb80cfa605372b42da3bb927491eae3c5750
		return customerRepository.findUserByCustomerId(customerId);
	}

	// validate customer method
	@Override
<<<<<<< HEAD
	public Boolean validateCustomer(Customer cust) {
=======
	public boolean validateCustomer(int customerId,String password) {
>>>>>>> 76abbb80cfa605372b42da3bb927491eae3c5750

		Customer custId = customerRepository.findUserByCustomerId(customerId);

		try {
			if ( custId.getPassword().equals(password)) {

				return true;
				

			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			return false;
		}

	}

}
