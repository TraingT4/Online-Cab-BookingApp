package com.cg.sprint.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Driver;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.DriverNotFoundException;
import com.cg.sprint.exception.InvalidCarTypeException;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.repository.DriverRepository;
import com.cg.sprint.service.CabService;

@Service
public class CabServiceImpl implements CabService {

	String drexcp = "No such driver found";
	String cabexcp = "No such cab found";
	String drex="Driver is already assigned to another Cab.";

	@Autowired
	CabRepository cabRepository;

	@Autowired
	DriverRepository driverRepository;

	//insertion of driver
	@Override
	public Cab insertCab(Cab cab, Long driverId) throws DriverNotFoundException {
		Optional<Driver> driverOpt = driverRepository.findById(driverId);
		if (driverOpt.isPresent()) {
			Driver driver = driverOpt.get();
			List<Cab> cab2=cabRepository.findAll();//checking for driverId whether it is assigned to another cab or not
			Boolean status=true;
			for(Cab cabop:cab2)
			{
				if(driverId.equals(cabop.getDriver().getDriverId()))
				{
					status=false;
					break;
				}
			}
			if(Boolean.TRUE.equals(status))
			{
			Cab cab1 = cab;
			cab1.setDriver(driver);//assigning the new driver
			cab=cabRepository.save(cab);//save the new cab
			}
			else
			{
				throw new DriverNotFoundException(drex);
			}
			return cab;
		} else {
			throw new DriverNotFoundException(drexcp);
		}
	}

	//Updating the cab
	@Override
	public Cab updateCab(Cab cab) throws CabNotFoundException {
		Optional<Cab> cabOpt = cabRepository.findById(cab.getCabId());
		if (cabOpt.isPresent()) {
			Cab cab1 = cabOpt.get();
			List<Cab> cab2=cabRepository.findAll();//checking for driverId whether it is assigned to another cab or not
			Boolean status=true;
			for(Cab cabop:cab2)
			{
				if(!cabop.getCabId().equals(cab.getCabId())) {
				if(Objects.equals(cabop.getDriver().getDriverId(), cab.getDriver().getDriverId()))
				{
					status=false;
					break;
				}}
			}
			if(Boolean.TRUE.equals(status))
			{
			cab1.setCabId(cab.getCabId());//updating the cab
			cab1.setCarType(cab.getCarType());
			cab1.setPerKmRate(cab.getPerKmRate());
			cab1.setDriver(cab.getDriver());
			cab1=cabRepository.save(cab1);
			}
			else
			{
				throw new CabNotFoundException(drex);
			}
			return cab1;
		} else {
			throw new CabNotFoundException(cabexcp);
		}
	}

	//deleting the cab
	@Override
	public void deleteCab(Long cabId) throws CabNotFoundException {
		try {
			cabRepository.deleteById(cabId);//deleting the cab
		} catch (Exception ex) {
			throw new CabNotFoundException(cabexcp);
		}
	}

	//viewing the list of cab types
	@Override
	public List<Cab> viewCabsOfType(String carType) throws InvalidCarTypeException {
		List<Cab> cab1 = new ArrayList<>();
		List<Cab> cab = cabRepository.findAll();
		for (Cab cabop : cab) {
			if (cabop.getCarType().equalsIgnoreCase(carType)) {
				cab1.add(cabop);
			}
		}
		if (!(carType.equalsIgnoreCase("XUV")||carType.equalsIgnoreCase("mini"))) {
			throw new InvalidCarTypeException("Car type is Invalid.");
		} else {
			return cab1;
		}
	}

	//viewing the count of cab types
	@Override
	public Long countCabsOfType(String carType) throws InvalidCarTypeException {
		Long count = 0L;
		List<Cab> cab = cabRepository.findAll();
		for (Cab cabop : cab) {
			if (cabop.getCarType().equalsIgnoreCase(carType)) {
				count++;
			}
		}
		if (!(carType.equalsIgnoreCase("XUV")||carType.equalsIgnoreCase("mini"))) {
			throw new InvalidCarTypeException("Invalid car type.");
		} else {
			return count;
		}
	}

}
