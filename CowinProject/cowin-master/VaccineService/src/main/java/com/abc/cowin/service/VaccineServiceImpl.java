package com.abc.cowin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.cowin.entity.VaccineEntity;
import com.abc.cowin.exception.VaccineNotFoundException;
import com.abc.cowin.model.Vaccine;
import com.abc.cowin.repository.VaccineRepository;
import com.abc.cowin.util.EntityModelUtil;

@Service
public class VaccineServiceImpl implements VaccineService {
	
	@Autowired
	private VaccineRepository vaccineRepository;
	
	@Override
	public Vaccine saveVaccine(Vaccine vaccine) {
		
		VaccineEntity vaccineEntity =vaccineRepository.save(EntityModelUtil.vaccineModelToEntity(vaccine));
		
		return EntityModelUtil.vaccineEntityToModel(vaccineEntity);    
		
	}
	
	@Override
	public Vaccine updateVaccine(Vaccine vaccine) {
		
		Optional<VaccineEntity> optionalVaccineEntity =vaccineRepository.findById(vaccine.getVaccineId());
		
		if(optionalVaccineEntity.isEmpty()) {
			throw new VaccineNotFoundException(" Vaccine is not available with id : "+vaccine.getVaccineId());
		}
		
		VaccineEntity updateVaccineEntity =vaccineRepository.save(EntityModelUtil.vaccineModelToEntity(vaccine));
		
		return EntityModelUtil.vaccineEntityToModel(updateVaccineEntity);	
	}
	
	@Override
	public void deleteVaccine(int vaccineId) {
		
		Optional<VaccineEntity> optionalVaccineEntity =vaccineRepository.findById(vaccineId);
		
		if(optionalVaccineEntity.isPresent()) {
			vaccineRepository.deleteById(vaccineId);
		}
		else {
			throw new VaccineNotFoundException(" vaccine is not available with id :"+vaccineId);
		}		
	}

	@Override
	public Vaccine getVaccineById(int vaccineId) throws VaccineNotFoundException{
		
		Optional<VaccineEntity> optionalVaccine = vaccineRepository.findById(vaccineId);
		
		if(optionalVaccine.isEmpty()) {
			throw new VaccineNotFoundException("Sorry! Vaccine is not available with id: "+vaccineId);
		}
		return EntityModelUtil.vaccineEntityToModel(optionalVaccine.get());		
	}
		
}
