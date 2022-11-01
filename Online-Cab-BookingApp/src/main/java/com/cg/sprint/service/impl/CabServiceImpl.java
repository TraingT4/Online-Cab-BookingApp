package com.cg.sprint.service.impl;

import java.util.ArrayList;
import java.util.List;
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
	String dra="Driver is already assigned to another Cab.";

	@Autowired
	CabRepository cabRepository;

	@Autowired
	DriverRepository driverRepository;

	@Override
	public Cab insertCab(Cab cab, Long driverId) throws DriverNotFoundException {
		Optional<Driver> driverOpt = driverRepository.findById(driverId);
		if (driverOpt.isPresent()) {
			Driver driver = driverOpt.get();
			List<Cab> cab2=cabRepository.findAll();
			Boolean status=true;
			for(Cab cabop:cab2)
			{
				if(cabop.getDriver().getDriverId()==driverId)
				{
					status=false;
					break;
				}
			}
			if(status)
			{
			Cab cab1 = cab;
			cab1.setDriver(driver);
			cab=cabRepository.save(cab);
			}
			else
			{
				throw new DriverNotFoundException(dra);
			}
			return cab;
		} else {
			throw new DriverNotFoundException(drexcp);
		}
	}

	@Override
	public Cab updateCab(Cab cab) throws CabNotFoundException {
		Optional<Cab> cabOpt = cabRepository.findById(cab.getCabId());
		if (cabOpt.isPresent()) {
			Cab cab1 = cabOpt.get();
			List<Cab> cab2=cabRepository.findAll();
			Boolean driverOpt=true;
			for(Cab cabop:cab2)
			{
				if(cabop.getDriver().getDriverId()==cab.getDriver().getDriverId())
				{
					driverOpt=false;
					break;
				}
			}
			if(driverOpt)
			{
			cab1.setCabId(cab.getCabId());
			cab1.setCarType(cab.getCarType());
			cab1.setPerKmRate(cab.getPerKmRate());
			cab1.setDriver(cab.getDriver());
			cabRepository.save(cab1);
			}
			else
			{
				throw new CabNotFoundException(dra);
			}
			return cab1;
		} else {
			throw new CabNotFoundException(cabexcp);
		}
	}

	@Override
	public void deleteCab(Long cabId) throws CabNotFoundException {
		try {
			cabRepository.deleteById(cabId);
		} catch (Exception ex) {
			throw new CabNotFoundException(cabexcp);
		}
	}

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
