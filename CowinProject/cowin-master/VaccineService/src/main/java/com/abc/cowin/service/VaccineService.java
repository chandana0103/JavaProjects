package com.abc.cowin.service;

import com.abc.cowin.model.Vaccine;

public interface VaccineService {
	
	public Vaccine saveVaccine(Vaccine vaccine);

	public Vaccine updateVaccine(Vaccine vaccine);
	
	public void deleteVaccine(int vaccineId);
	
	public Vaccine getVaccineById(int vaccineId);

	
}
