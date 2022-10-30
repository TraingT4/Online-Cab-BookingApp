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

import com.cg.sprint.entity.Driver;
//import com.cg.sprint.service.CustomerService;
import com.cg.sprint.service.DriverService;
@RestController
@RequestMapping("/api/drivers")
public class DriverController {
	@Autowired
	DriverService driverService;
	
	
	//inserting the driver
	@PostMapping("/")
	public ResponseEntity<Driver> insertDriver(@RequestBody @Valid Driver driver){
		Driver d = driverService.insertDriver(driver);
		return new ResponseEntity<>(d, HttpStatus.CREATED);
	}
	
	//update the driver
	@PutMapping("/")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver){
		Driver d = driverService.updateDriver(driver);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	//delete driver using driver id
	@DeleteMapping("/{driver_id}")
	public ResponseEntity<String> deleteDriver(@PathVariable("driver_id") Long driverId){
		driverService.deleteDriver(driverId);
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.NO_CONTENT);
	}
	
	//get best drivers
	@GetMapping("/")
	public ResponseEntity<List<Driver>> getallDrivers() {
		List<Driver> drivers = driverService.viewDrivers();
		return new ResponseEntity<>(drivers, HttpStatus.OK);
	}
	
	//get driver using driver id
	@GetMapping("/{driver_id}")
	public ResponseEntity<Driver> getDriver(@PathVariable("driver_id") Long driverId) {
		Driver driver = driverService.viewDriver(driverId);
		return new ResponseEntity<>(driver, HttpStatus.OK);
	}
}
