package com.cg.sprint.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Driver;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.InvalidCarTypeException;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.repository.DriverRepository;

@ExtendWith(MockitoExtension.class)
class CabServiceTest {
	@InjectMocks
	private CabServiceImpl cabService;

	@Mock
	private CabRepository cabRepository;

	@Mock
	private DriverRepository driverRepository;

	@Test
	void insertCabTest() {
		Optional<Cab> CabOpt = getCabMockData();
		Cab Cab = CabOpt.get();
		Mockito.when(cabRepository.save(Cab)).thenReturn(Cab);
		Mockito.when(driverRepository.findById(Cab.getDriver().getDriverId())).thenReturn(Optional.of(Cab.getDriver()));
		Cab cab = cabService.insertCab(Cab, Cab.getDriver().getDriverId());

		assertThat(cab.getCarType().equals(Cab.getCarType()));
	}

	@Test
	void updateCabTest() {

		Long cabId = 1L;
		Optional<Cab> cabOpt = getCabMockData();
		Cab cab = cabOpt.get();
		Mockito.when(cabRepository.findById(cabId)).thenReturn(cabOpt);
		Mockito.when(cabRepository.save(cab)).thenReturn(cab);

		Cab updateCab = new Cab();
		try {
			updateCab = cabService.updateCab(cab);
		} catch (CabNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertThat(cab.getCarType().equals(updateCab.getCarType()));

	}

	@Test
	void getCabTypesTest() {
		List<Cab> cabs = getCabsMockData();
		Mockito.when(cabRepository.findAll()).thenReturn(cabs);
		List<Cab> cabs1 = new ArrayList<>();
		try {
			cabs1 = cabService.viewCabsOfType("mini");
		} catch (InvalidCarTypeException e) {
			e.getMessage();
		}
		for (Cab cab : cabs) {
			if (!cab.getCarType().equals("mini")) {
				cabs.remove(cab);
			}
		}
		assertThat(cabs.containsAll(cabs1));
	}

	@Test
	void getCountCabTypesTest() {
		List<Cab> cabs = getCabsMockData();
		Mockito.when(cabRepository.findAll()).thenReturn(cabs);
		Long count = 0L;
		try {
			count = cabService.countCabsOfType("mini");
		} catch (InvalidCarTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Cab cab : cabs) {
			if (cab.getCarType().equals("mini")) {
				count++;
			}
		}
		assertThat(cabs.size() == count);
	}

	private List<Cab> getCabsMockData() {
		List<Cab> cabs = new ArrayList<Cab>();
		Cab cab1 = new Cab();
		Cab cab2 = new Cab();
		cab1.setCabId(1L);
		cab2.setCabId(2L);
		cab1.setCarType("mini");
		cab2.setCarType("XUV");
		return cabs;
	}

	private Optional<Cab> getCabMockData() {
		Cab cab = new Cab();
		cab.setCabId(1L);
		cab.setCarType("mini");
		cab.setPerKmRate(23f);
		Driver driver = new Driver();
		driver.setDriverId(1L);
		cab.setDriver(driver);
		return Optional.of(cab);
	}
}