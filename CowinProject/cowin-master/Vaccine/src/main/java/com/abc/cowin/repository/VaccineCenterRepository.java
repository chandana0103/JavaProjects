package com.abc.cowin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.cowin.entity.VaccineCenterEntity;



@Repository
public interface VaccineCenterRepository extends JpaRepository<VaccineCenterEntity,Integer> {
	
	public List<VaccineCenterEntity> findByState(String state);
	public List<VaccineCenterEntity> findByPincode(int pincode);
	public List<VaccineCenterEntity> findByDistrict(String district);
	
	
	
	
}
