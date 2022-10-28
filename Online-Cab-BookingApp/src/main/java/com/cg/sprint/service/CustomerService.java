package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.entity.Customer;

public interface CustomerService {
	Customer insertCustomer(Customer cust);
	Customer updateCustomer(Customer cust);
	void deleteCustomer(Long customerId);
	List<Customer> viewCustomers();
<<<<<<< HEAD
	Customer viewCustomer(Long customerId);
	Boolean validateCustomer(Customer cust);
=======
	Customer viewCustomer(int customerId);
	boolean validateCustomer(int customerId,String password);
>>>>>>> 76abbb80cfa605372b42da3bb927491eae3c5750
}
