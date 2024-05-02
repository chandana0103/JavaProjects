package com.abc.cowin.controller;

import java.util.List;

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

import com.abc.cowin.model.VaccineCenter;
import com.abc.cowin.service.VaccineCenterService;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {
	
	@Autowired
	private VaccineCenterService vaccineCenterService;
	
	@PostMapping("/save")
	public ResponseEntity<VaccineCenter> addVaccineCenter(@RequestBody VaccineCenter vaccineCenter) {
		VaccineCenter newVaccineCenter =vaccineCenterService.saveVaccineCenter(vaccineCenter);
		ResponseEntity<VaccineCenter> responseEntity =new ResponseEntity<>(newVaccineCenter, HttpStatus.CREATED);
		return responseEntity;
	}
		
	@PutMapping("/update")
	public ResponseEntity<VaccineCenter> updateVaccineCenter(@RequestBody VaccineCenter vaccineCenter){
		VaccineCenter updatedVaccineCenter =vaccineCenterService.updateVaccineCenter(vaccineCenter);
		return new ResponseEntity<>(updatedVaccineCenter,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{vid}")
	public ResponseEntity<?> deleteVaccineCenter(@PathVariable("vid")int centerId){
		vaccineCenterService.deleteVaccineCenter(centerId);
		return new ResponseEntity<>("Vaccine Deleted with Id :"+centerId,HttpStatus.OK);
	}
	
	@GetMapping("/state/{vid}")
	public List<VaccineCenter> getAllVaccineCenterByState(@PathVariable("vid") String state) {
		List<VaccineCenter> vaccineCenterList =vaccineCenterService.getVaccineCenterByState(state);
		return vaccineCenterList;
	}
	
	@GetMapping("/pincode/{vid}")
	public List<VaccineCenter> getAllVaccineCenterByPincode(@PathVariable("vid") int pincode) {
		List<VaccineCenter> vaccineCenterList =vaccineCenterService.getVaccineCenterByPincode(pincode);
		return vaccineCenterList;
	}
	
	@GetMapping("/district/{vid}")
	public List<VaccineCenter> getAllVaccineCenterByDistrict(@PathVariable("vid") String district) {
		List<VaccineCenter> vaccineCenterList =vaccineCenterService.getVaccineCenterByDistrict(district);
		return vaccineCenterList;
	}
}

