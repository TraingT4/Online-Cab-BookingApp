package com.cg.sprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.service.AdminService;
import com.cg.sprint.service.CustomerService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	CustomerService customerService;
	@Autowired
	AdminService admin1;

	@PostMapping("/customer")
	public ResponseEntity<String> loginCustomer(@RequestBody Customer cust1) {
		String message = customerService.validateCustomer(cust1.getCustomerId(), cust1.getPassword());
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}

	@PostMapping("/admin")
	public ResponseEntity<String> loginAdmin(@RequestBody Admin admin) {
		String message = admin1.validateAdmin(admin.getAdminId(), admin.getPassword());
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);

	}
}
