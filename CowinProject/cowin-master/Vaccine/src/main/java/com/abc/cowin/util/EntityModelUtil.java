package com.abc.cowin.util;

import java.util.ArrayList;
import java.util.List;

import com.abc.cowin.entity.VaccineCenterEntity;
import com.abc.cowin.model.VaccineCenter;

public class EntityModelUtil {
	
	public static VaccineCenterEntity vaccineCenterModelToEntity(VaccineCenter vaccineCenter) {
		
		VaccineCenterEntity vaccineCenterEntity =new VaccineCenterEntity();
		vaccineCenterEntity.setCenterId(vaccineCenter.getCenterId());
		vaccineCenterEntity.setDistrict(vaccineCenter.getDistrict());
		vaccineCenterEntity.setPincode(vaccineCenter.getPincode());
		vaccineCenterEntity.setState(vaccineCenter.getState());
		vaccineCenterEntity.setVaccineCenterName(vaccineCenter.getVaccineCenterName());
		return vaccineCenterEntity;		
	}
	
	public static VaccineCenter vaccineCenterEntityToModel(VaccineCenterEntity vaccineCenterEntity) {
		
		VaccineCenter vaccineCenter =new VaccineCenter();
		vaccineCenter.setCenterId(vaccineCenterEntity.getCenterId());
		vaccineCenter.setDistrict(vaccineCenterEntity.getDistrict());
		vaccineCenter.setPincode(vaccineCenterEntity.getPincode());
		vaccineCenter.setState(vaccineCenterEntity.getState());
		vaccineCenter.setVaccineCenterName(vaccineCenterEntity.getVaccineCenterName());
		return vaccineCenter;
		
	}
	public static List<VaccineCenter> vaccineCenterEntityToModelList(List<VaccineCenterEntity> entityList) {

		List<VaccineCenter> vaccineCenterList = new ArrayList<>();

		entityList.forEach(entity -> {
			VaccineCenter vaccineCenter =new VaccineCenter();
			vaccineCenter.setCenterId(entity.getCenterId());
			vaccineCenter.setDistrict(entity.getDistrict());
			vaccineCenter.setPincode(entity.getPincode());
			vaccineCenter.setState(entity.getState());
			vaccineCenter.setVaccineCenterName(entity.getVaccineCenterName());

			vaccineCenterList.add(vaccineCenter);
		});

		return vaccineCenterList;
}
}