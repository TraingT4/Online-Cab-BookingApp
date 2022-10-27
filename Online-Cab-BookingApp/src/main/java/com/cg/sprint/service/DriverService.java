package com.cg.sprint.service;

import java.util.List;
import java.util.function.Supplier;

import com.cg.sprint.entity.Driver;

public interface DriverService {

	Driver insertDriver(Driver driver);
	Driver updateDriver(Driver driver);
	void deleteDriver(int driverId);
	List<Driver> viewBestDrivers();
	Driver viewDriver(int driverId);
}
