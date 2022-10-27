package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.entity.Customer;

public interface CustomerService {
	Customer insertCustomer(Customer cust);
	Customer updateCustomer(Customer cust);
	void deleteCustomer(int customerId);
	List<Customer> viewCustomers();
	Customer viewCustomer(int customerId);
	Customer validateCustomer(String username, String password);
}
