package com.cg.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.dto.CabDto;
import com.cg.sprint.dto.Convertor;
import com.cg.sprint.entity.Cab;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.DriverNotFoundException;
import com.cg.sprint.exception.InvalidCarTypeException;
import com.cg.sprint.repository.DriverRepository;
import com.cg.sprint.service.CabService;

@RestController
@RequestMapping("api/cabs")
public class CabController {

	@Autowired
	CabService cabService;
	@Autowired
	DriverRepository driverRepository;

	Convertor convertor =new Convertor();
	
	@PostMapping("/{driver_id}")
	public ResponseEntity<Cab> insertCab(@RequestBody @Valid CabDto cabdto,@PathVariable("driver_id") Long driverId) throws DriverNotFoundException{
		Cab cab=convertor.cabDtoToEntity(cabdto);
		cabService.insertCab(cab,driverId);
		return new ResponseEntity<>(cab, HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Cab> updateCab(@RequestBody CabDto cabdto) throws CabNotFoundException{
		Cab cab=convertor.cabDtoToEntity(cabdto);
		Cab cab1 = cabService.updateCab(cab);
		return new ResponseEntity<>(cab1, HttpStatus.OK);
	}
	
	@DeleteMapping("/{cabId}")
	public ResponseEntity<String> deleteCab(@PathVariable("cabId") Long cabId) throws CabNotFoundException{
		cabService.deleteCab(cabId);
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{cabType}")
	public ResponseEntity<List<Cab>> getCabTypes(@PathVariable("cabType") String carType) throws InvalidCarTypeException {
		List<Cab> cabs = cabService.viewCabsOfType(carType);
		return new ResponseEntity<>(cabs, HttpStatus.OK);
	}
	
	@GetMapping("/count/{cabType}")
	public ResponseEntity<Long> getCountCabTypes(@PathVariable("cabType") String carType) throws InvalidCarTypeException {
		Long cabs = cabService.countCabsOfType(carType);
		return new ResponseEntity<>(cabs, HttpStatus.OK);
	}
	
}
