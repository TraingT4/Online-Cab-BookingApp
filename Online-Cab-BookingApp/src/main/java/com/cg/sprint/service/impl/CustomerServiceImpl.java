package com.cg.sprint.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Customer;
import com.cg.sprint.exception.CustomerNotFoundException;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	String custexcp = "No customer found with id: ";

	// insert customer method
	@Override
	public Customer insertCustomer(Customer cust) {
		customerRepository.save(cust);
		return cust;
	}

	// update customer method
	@Override
	public Customer updateCustomer(Customer cust) throws CustomerNotFoundException {
		Optional<Customer> cusOpt = customerRepository.findById(cust.getCustomerId());
		Customer cust1 = null;
		if (cusOpt.isPresent()) {
			cust1 = cusOpt.get();
			cust1.setCustomerId(cust.getCustomerId());
			cust1.setUsername(cust.getUsername());
			cust1.setPassword(cust.getPassword());
			cust1.setAddress(cust.getAddress());
			cust1.setMobileNumber(cust.getMobileNumber());
			cust1.setEmail(cust.getEmail());
			customerRepository.save(cust1);
			return cust1;
		} else {
			throw new CustomerNotFoundException(custexcp + cust.getCustomerId());
		}
	}

	// delete customer using customer id method
	@Override
	public void deleteCustomer(Long customerId) {
		Optional<Customer> cusOpt = customerRepository.findById(customerId);
		if (cusOpt.isPresent()) {
			customerRepository.deleteById(customerId);
		} else {
			throw new CustomerNotFoundException(custexcp + customerId);
		}
	}

	// view all customers method
	@Override
	public List<Customer> viewCustomers() {
		return customerRepository.findAll();
	}

	// view customer using customer id method
	@Override
	public Customer viewCustomer(Long customerId) {
		Optional<Customer> cusOpt = customerRepository.findById(customerId);
		if (cusOpt.isPresent()) {
			return customerRepository.findUserByCustomerId(customerId);
		} else {
			throw new CustomerNotFoundException(custexcp + customerId);
		}
	}

	// validate customer method
	@Override
	public String validateCustomer(Long customerId, String password) {
		Customer cust = customerRepository.findUserByCustomerId(customerId);
		if (cust != null && cust.getPassword().equals(password)) {
			return "Login Successful";
		} else {
			throw new CustomerNotFoundException("Either customer id or password is incorrect");
		}
	}

}
