package com.cg.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.dto.Convertor;
import com.cg.sprint.dto.CustomerDto;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	Convertor convertor=new Convertor();
	
	//inserting the customer
	@PostMapping("/")
	public ResponseEntity<Customer> insertCustomer(@RequestBody @Valid CustomerDto customerDto){
		Customer customer=convertor.customerEntitytoDto(customerDto);
		Customer cus = customerService.insertCustomer(customer);
		return new ResponseEntity<>(cus, HttpStatus.CREATED);
	}
	
	//update the customer
	@PutMapping("/")
	public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid CustomerDto customerDto){
		Customer customer=convertor.customerEntitytoDto(customerDto);
		Customer cus = customerService.updateCustomer(customer);
		return new ResponseEntity<>(cus, HttpStatus.OK);
	}
	
	//delete customer using customer id
	@DeleteMapping("/{customer_id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customer_id") Long customerId){
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.NO_CONTENT);
	}
	
	//get all customers
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getallCustomers() {
		List<Customer> customers = customerService.viewCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	//get customer using customer id
	@GetMapping("/{customer_id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customer_id") Long customerId) {
		Customer customer = customerService.viewCustomer(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
}
