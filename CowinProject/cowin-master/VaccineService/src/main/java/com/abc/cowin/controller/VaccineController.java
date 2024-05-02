package com.abc.cowin.controller;

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

import com.abc.cowin.model.Vaccine;
import com.abc.cowin.service.VaccineService;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {
	
	@Autowired
	private VaccineService vaccineService;
	
	@PostMapping("/save")
	public ResponseEntity<Vaccine> addVaccine(@RequestBody Vaccine vaccine) {
		Vaccine newVaccine =vaccineService.saveVaccine(vaccine);
		ResponseEntity<Vaccine> responseEntity =new ResponseEntity<>(newVaccine, HttpStatus.CREATED);
		return responseEntity;
	}
		
	@PutMapping("/update")
	public ResponseEntity<Vaccine> updateVaccine(@RequestBody Vaccine vaccine){
		Vaccine updatedVaccine =vaccineService.updateVaccine(vaccine);
		return new ResponseEntity<>(updatedVaccine,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{vid}")
	public ResponseEntity<?> deleteVaccine(@PathVariable("vid")int vaccineId){
		vaccineService.deleteVaccine(vaccineId);
		return new ResponseEntity<>("Vaccine Deleted with Id :"+vaccineId,HttpStatus.OK);
	}
	
	@GetMapping("/get/{vid}")
	public ResponseEntity<?> getVaccineById(@PathVariable("vid") int vaccineId) {
		Vaccine vaccine =vaccineService.getVaccineById(vaccineId);
		return new ResponseEntity<>(vaccine,HttpStatus.OK);
	}
}

