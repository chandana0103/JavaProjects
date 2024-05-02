package com.abc.cowin.util;

import org.springframework.stereotype.Component;

import com.abc.cowin.entity.VaccineEntity;
import com.abc.cowin.model.Vaccine;

public class EntityModelUtil {
	
	public static VaccineEntity vaccineModelToEntity(Vaccine vaccine) {
		
		VaccineEntity vaccineEntity =new VaccineEntity();
		vaccineEntity.setVaccineId(vaccine.getVaccineId());
		vaccineEntity.setVaccineName(vaccine.getVaccineName());
		vaccineEntity.setManufactureDate(vaccine.getManufactureDate());
		vaccineEntity.setExpiryDate(vaccine.getExpiryDate());
		vaccineEntity.setCompanyName(vaccine.getCompanyName());
		return vaccineEntity;		
	}
	
	public static Vaccine vaccineEntityToModel(VaccineEntity vaccineEntity) {
		
		Vaccine vaccine =new Vaccine();
		vaccine.setVaccineId(vaccineEntity.getVaccineId());
		vaccine.setVaccineName(vaccineEntity.getVaccineName());
		vaccine.setManufactureDate(vaccineEntity.getManufactureDate());
		vaccine.setExpiryDate(vaccineEntity.getExpiryDate());
		vaccine.setCompanyName(vaccineEntity.getCompanyName());
		return vaccine;
		
	}
}