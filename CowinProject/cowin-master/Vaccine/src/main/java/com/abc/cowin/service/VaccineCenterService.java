package com.abc.cowin.service;

import java.util.List;

import com.abc.cowin.entity.VaccineCenterEntity;
import com.abc.cowin.model.VaccineCenter;

public interface VaccineCenterService {
	
	public VaccineCenter saveVaccineCenter(VaccineCenter vaccineCenter);

	public VaccineCenter updateVaccineCenter(VaccineCenter vaccineCenter);
	
	public void deleteVaccineCenter(int centerId);
	
	public List<VaccineCenter> getVaccineCenterByState(String state);
	public List<VaccineCenter> getVaccineCenterByPincode(int pincode);
	public List<VaccineCenter> getVaccineCenterByDistrict(String district);
	

	
}
