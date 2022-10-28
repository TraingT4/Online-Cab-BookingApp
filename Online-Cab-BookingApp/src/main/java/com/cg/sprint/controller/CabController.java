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

import com.cg.sprint.entity.Cab;
import com.cg.sprint.service.CabService;

@RestController
@RequestMapping("api/cab")
public class CabController {

	@Autowired
	CabService cabService;
	
	
	@PostMapping("/insert")
	public ResponseEntity<Cab> insertCab(@RequestBody @Valid Cab cab){
		Cab cab1 = cabService.insertCab(cab);
		ResponseEntity<Cab> response = new ResponseEntity<Cab>(cab1, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/update")
	public ResponseEntity<Cab> updateCab(@RequestBody Cab cab){
		Cab cab1 = cabService.updateCab(cab);
		ResponseEntity<Cab> reponse = new ResponseEntity<Cab>(cab1, HttpStatus.OK);
		return reponse;
	}
	
	@DeleteMapping("/delete/{cabId}")
	public ResponseEntity<String> deleteCab(@PathVariable("cabId") Long cabId){
		cabService.deleteCab(cabId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
	}
	
	@GetMapping("/carType/{cabType}")
	public ResponseEntity<List<Cab>> getCabTypes(@PathVariable("cabType") String carType) {
		List<Cab> cabs = cabService.viewCabsOfType(carType);
		ResponseEntity<List<Cab>> response = new ResponseEntity<>(cabs, HttpStatus.OK);
		return response;
	}
	
	
}
