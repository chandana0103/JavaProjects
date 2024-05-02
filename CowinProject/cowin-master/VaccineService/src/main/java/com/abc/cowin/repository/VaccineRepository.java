package com.abc.cowin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.cowin.entity.VaccineEntity;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineEntity,Integer> {	
	
}
