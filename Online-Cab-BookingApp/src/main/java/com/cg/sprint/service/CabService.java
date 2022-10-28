package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.entity.Cab;


public interface CabService {
	Cab insertCab(Cab cab);
	Cab updateCab(Cab cab);
	Cab deleteCab(Long cabId);
	List<Cab> viewCabsOfType(String carType);
	Long countCabsOfType(String carType);
}
