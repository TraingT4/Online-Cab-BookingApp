package com.cg.sprint.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Driver;
import com.cg.sprint.exception.DriverNotFoundException;
import com.cg.sprint.repository.DriverRepository;
import com.cg.sprint.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	DriverRepository driverRepository;
	String driverexcp = "No such driver found";
	
	//insert driver method
	@Override
	public Driver insertDriver(Driver driver) {
		driverRepository.save(driver);
		return driver;
	}

	//update driver method
	@Override
	public Driver updateDriver(Driver driver,Long driverId) throws DriverNotFoundException{
		Optional<Driver> driverOpt = driverRepository.findById(driverId);
		Driver driver1 = new Driver();
		if(driverOpt.isPresent())
		{
		driver1 = driverOpt.get();
		driver1.setLicenceNO(driver.getLicenceNO());
		driver1.setRating(driver.getRating());
		driver1.setUsername(driver.getUsername());
		driver1.setPassword(driver.getPassword());
		driver1.setMobileNumber(driver.getMobileNumber());
		driver1.setAddress(driver.getAddress());
		driver1.setEmail(driver.getEmail());
		driverRepository.save(driver1);
		return driver1;
		}
		else {
			throw new DriverNotFoundException(driverexcp); 
		}
	}

	//delete driver using driver id method
	@Override
	public void deleteDriver(Long driverId) throws DriverNotFoundException{
		Optional<Driver> driver = driverRepository.findById(driverId);
		if(driver.isPresent())
		{
			driverRepository.deleteById(driverId);
		}
		else {
			throw new DriverNotFoundException(driverexcp); 
		}
	}

	//view drivers method
	@Override
	public List<Driver> viewDrivers() {
		return driverRepository.findAll();	
	}
	
	//view best drivers method
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

	//view driver using driver id method
	@Override
	public Driver viewDriver(Long driverId) throws DriverNotFoundException{
		Optional<Driver> driver = driverRepository.findById(driverId);
		Driver driver1=null;
		if(driver.isPresent())
		{
			driver1=driver.get();
		return driver1;
		}
		else {
			throw new DriverNotFoundException(driverexcp); 
		}
	}

}
