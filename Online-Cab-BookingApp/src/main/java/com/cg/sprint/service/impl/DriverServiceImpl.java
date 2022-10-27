package com.cg.sprint.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.sprint.entity.Driver;
import com.cg.sprint.repository.DriverRepository;
import com.cg.sprint.service.DriverService;

public class DriverServiceImpl implements DriverService {
	@Autowired
	DriverRepository driverRepository;
	
	
	//insert Driver method
	@Override
	public Driver insertDriver(Driver driver) {
		driverRepository.save(driver);
		return driver;
	}

	//update Driver method
	@Override
	public Driver updateDriver(Driver driver) {
		Optional<Driver> driverOpt = driverRepository.findById(driver.getDriverId());
		Driver driver1 = null;
		driver1 = driverOpt.get();
		driver1.setDriverId(driver.getDriverId());
		driver1.setLicenceNO(driver.getLicenceNO());
		driver1.setCab(driver.getCab());
		driver1.setRating(driver.getRating());
		driverRepository.save(driver1);

		return driver1;
	}

	//delete Driver using Driver id method
	@Override
	public void deleteDriver(int driverId) {
		driverRepository.deleteById(driverId);
	}

	//view best Drivers method
	@Override
	public List<Driver> viewBestDrivers() {
		List<Driver> drivers=driverRepository.findAll();	
		List<Driver> BestDrivers= new ArrayList<Driver>();
		for(Driver d:drivers)
		{
			if(d.getRating()>=4.5)
			{
				BestDrivers.add(d);
			}
		}
		return BestDrivers;
	}

	//view Driver using Driver id method
	@Override
	public Driver viewDriver(int driverId) {
		Optional<Driver> driver = driverRepository.findById(driverId);
		return driver.get();
	}

}