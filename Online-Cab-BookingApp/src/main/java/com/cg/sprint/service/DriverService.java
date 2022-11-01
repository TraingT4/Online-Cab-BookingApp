package com.cg.sprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Driver;
import com.cg.sprint.exception.DriverNotFoundException;


@Service
public interface DriverService {

	Driver insertDriver(Driver driver);
	Driver updateDriver(Driver driver, Long driverId) throws DriverNotFoundException;
	void deleteDriver(Long driverId) throws DriverNotFoundException;
	List<Driver> viewDrivers();
	List<Driver> viewBestDrivers();
	Driver viewDriver(Long driverId) throws DriverNotFoundException;
}
