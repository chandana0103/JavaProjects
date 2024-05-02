package com.abc.cowin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.cowin.entity.VaccineCenterEntity;
import com.abc.cowin.exception.VaccineCenterNotFoundException;
import com.abc.cowin.model.VaccineCenter;
import com.abc.cowin.repository.VaccineCenterRepository;
import com.abc.cowin.util.EntityModelUtil;

@Service
public class VaccineCenterServiceImpl implements VaccineCenterService {
	
	@Autowired
	private VaccineCenterRepository vaccineCenterRepository;
	
	@Override
	public VaccineCenter saveVaccineCenter(VaccineCenter vaccineCenter) {
		
		VaccineCenterEntity vaccineCenterEntity =vaccineCenterRepository.save(EntityModelUtil.vaccineCenterModelToEntity(vaccineCenter));
		
		return EntityModelUtil.vaccineCenterEntityToModel(vaccineCenterEntity);    
		
	}
	
	@Override
	public VaccineCenter updateVaccineCenter(VaccineCenter vaccineCenter) {
		
		Optional<VaccineCenterEntity> optionalVaccineEntity =vaccineCenterRepository.findById(vaccineCenter.getCenterId());
		
		if(optionalVaccineEntity.isEmpty()) {
			throw new VaccineCenterNotFoundException(" VaccineCenter is not available with id : "+vaccineCenter.getCenterId());
		}
		
		VaccineCenterEntity updateVaccineEntity =vaccineCenterRepository.save(EntityModelUtil.vaccineCenterModelToEntity(vaccineCenter));
		
		return EntityModelUtil.vaccineCenterEntityToModel(updateVaccineEntity);	
	}
	
	@Override
	public void deleteVaccineCenter(int centerId) {
		
		Optional<VaccineCenterEntity> optionalVaccineEntity =vaccineCenterRepository.findById(centerId);
		
		if(optionalVaccineEntity.isPresent()) {
			vaccineCenterRepository.deleteById(centerId);
		}
		else {
			throw new VaccineCenterNotFoundException(" vaccine center is not available with id :"+centerId);
		}		
	}
	@Override
	public List<VaccineCenter> getVaccineCenterByState(String state){
		
	List<VaccineCenterEntity> vaccineCenterList=vaccineCenterRepository.findByState(state);
	return EntityModelUtil.vaccineCenterEntityToModelList(vaccineCenterList);
	}
	@Override
	public List<VaccineCenter> getVaccineCenterByPincode(int pincode){
		
		List<VaccineCenterEntity> vaccineCenterList=vaccineCenterRepository.findByPincode(pincode);
		return EntityModelUtil.vaccineCenterEntityToModelList(vaccineCenterList);
		}
	@Override
	public List<VaccineCenter> getVaccineCenterByDistrict(String district){
		
		List<VaccineCenterEntity> vaccineCenterList=vaccineCenterRepository.findByDistrict(district);
		return EntityModelUtil.vaccineCenterEntityToModelList(vaccineCenterList);
		}
		
}
