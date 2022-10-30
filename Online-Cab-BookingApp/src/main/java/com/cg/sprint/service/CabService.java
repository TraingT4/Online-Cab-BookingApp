package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.DriverNotFoundException;
import com.cg.sprint.exception.InvalidCarTypeException;


public interface CabService {
	Cab insertCab(Cab cab, Long driverId) throws DriverNotFoundException;
	Cab updateCab(Cab cab) throws CabNotFoundException;
	void deleteCab(Long cabId) throws CabNotFoundException;
	List<Cab> viewCabsOfType(String carType)throws InvalidCarTypeException;
	Long countCabsOfType(String carType)throws InvalidCarTypeException;
}
