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
		customerRepository.save(cust);

		return cust;
	}

	// delete customer using customer id method
	@Override
	public void deleteCustomer(int customerId) {
		Customer cu = customerRepository.getOne(customerId);
		customerRepository.delete(cu);
	}

	// view all customers method
	@Override
	public List<Customer> viewCustomers() {
		return customerRepository.findAll();
	}

	// view customer using customer id method
	@Override
	public Customer viewCustomer(int customerId) {
		return customerRepository.findUserByCustomerId(customerId);
	}

	// validate customer method
	@Override
	public boolean validateCustomer(int customerId,String password) {

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
