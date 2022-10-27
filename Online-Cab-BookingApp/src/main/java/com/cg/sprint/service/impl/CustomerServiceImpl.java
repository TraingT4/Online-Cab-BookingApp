package com.cg.sprint.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.sprint.entity.Customer;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
	//insert customer method
	@Override
	public Customer insertCustomer(Customer cust) {
		customerRepository.save(cust);
		return cust;
	}

	//update customer method
	@Override
	public Customer updateCustomer(Customer cust) {
		Optional<Customer> custOpt = customerRepository.findById(cust.getCustomerId());
		Customer cust1 = null;
		cust1 = custOpt.get();
		cust1.setUsername(cust.getUsername());
		cust1.setPassword(cust.getPassword());
		cust1.setAddress(cust.getAddress());
		cust1.setMobileNumber(cust.getMobileNumber());
		cust1.setEmail(cust.getEmail());
		customerRepository.save(cust1);

		return cust1;
	}

	//delete customer using customer id method
	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);
	}

	//view all customers method
	@Override
	public List<Customer> viewCustomers() {
		return customerRepository.findAll();
	}

	//view customer using customer id method
	@Override
	public Customer viewCustomer(int customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		return customer.get();
	}

	//validate customer method
	@Override
	public Customer validateCustomer(String username, String password) {
		return null;
	}

}
