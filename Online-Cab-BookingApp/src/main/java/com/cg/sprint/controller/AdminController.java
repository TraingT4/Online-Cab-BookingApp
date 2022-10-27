package com.cg.sprint.controller;

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

import com.cg.sprint.entity.Admin;
import com.cg.sprint.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	//inserting the admin
	@PostMapping("/admin")
	public ResponseEntity<Admin> insertAdmin(@RequestBody @Valid Admin adm){
		Admin ad = adminService.insertAdmin(adm);
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(ad, HttpStatus.CREATED);
		return response;
	}
	
	//update the admin
	@PutMapping("/admin/{admin_id}")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin){
		Admin adm = adminService.updateAdmin(admin);
		ResponseEntity<Admin> reponse = new ResponseEntity<Admin>(adm, HttpStatus.OK);
		return reponse;
	}
	
	//delete admin using admin id
	@DeleteMapping("/admin/{admin_id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("admin_id") Integer adminId){
		adminService.deleteAdmin(adminId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
		
	}
}
