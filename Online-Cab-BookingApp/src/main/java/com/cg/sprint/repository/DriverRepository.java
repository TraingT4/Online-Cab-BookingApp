package com.cg.sprint.repository;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer>{
	Driver insertDriver(Driver driver);
	Driver updateDriver(Driver driver);
	void deleteDriver(int driverId);
	List<Driver> viewBestDrivers();
	Driver viewDriver(int driverId);
}
