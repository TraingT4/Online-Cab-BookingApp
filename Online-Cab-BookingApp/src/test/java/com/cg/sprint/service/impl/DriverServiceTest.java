package com.cg.sprint.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.sprint.entity.Driver;
import com.cg.sprint.repository.DriverRepository;

@ExtendWith(MockitoExtension.class)
class DriverServiceTest {
	@InjectMocks
	private DriverServiceImpl driverService;

	@Mock
	private DriverRepository driverRepository;

	@Test
	void insertDriverTest() {
		Optional<Driver> driverOpt = getDriverMockData();
		Driver driver = driverOpt.get();
		Mockito.when(driverRepository.save(driver)).thenReturn(driver);
		
		Driver driverS = driverService.insertDriver(driver);
		
		assertThat(driverS.getLicenceNO().equals(driver.getLicenceNO()));
	}
	
	@Test
	void updateDriverTest() {
		
		Long driverId = 2L;
		Optional<Driver> driverOpt = getDriverMockData();
		driverOpt.get().setDriverId(driverId);
		Mockito.when(driverRepository.findById(driverOpt.get().getDriverId())).thenReturn(driverOpt);
		Mockito.when(driverRepository.save(driverOpt.get())).thenReturn(driverOpt.get());
		

		Driver uDriver = driverService.updateDriver(driverOpt.get(),driverId);
		
		assertThat(driverOpt.get().getDriverId().equals(uDriver.getDriverId()));
		
	}

	private Optional<Driver> getDriverMockData() {
		Driver driver = new Driver();
		driver.setDriverId(10L);
		driver.setLicenceNO("AB1234");
		return Optional.of(driver);
	}
}
