package com.cg.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findUserByCustomerId(int customerId);

	//Customer findUserByUsername(String username);

}
