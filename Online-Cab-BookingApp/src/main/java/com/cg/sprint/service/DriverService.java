package com.cg.sprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Driver;


@Service
public interface DriverService {

	Driver insertDriver(Driver driver);
	Driver updateDriver(Driver driver);
	void deleteDriver(int driverId);
	List<Driver> viewBestDrivers();
	Driver viewDriver(int driverId);
}
