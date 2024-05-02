package com.abc.cowin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.cowin.entity.VaccineCenterEntity;
import com.abc.cowin.model.VaccineCenter;
import com.abc.cowin.repository.VaccineCenterRepository;
import com.abc.cowin.service.VaccineCenterService;
import com.abc.cowin.service.VaccineCenterServiceImpl;

@SpringBootTest
public class VaccineTest {
	@InjectMocks
	private VaccineCenterService vaccineService = new VaccineCenterServiceImpl();

	 @Mock
	private VaccineCenterRepository vaccineRepository;

	 @Test
	public void deleteVaccineById() {
		 int centerId = 1;
	 VaccineCenterEntity vaccineEntity = new VaccineCenterEntity();
	vaccineEntity.setCenterId(1);
	vaccineEntity.setVaccineCenterName("panki");
	vaccineEntity.setDistrict("kanpur");
	vaccineEntity.setPincode(208020);
	vaccineEntity.setState("uttar pradesh");
	
	

	Optional<VaccineCenterEntity> optionalVaccine = Optional.of(vaccineEntity);
	

	 when(vaccineRepository.findById(1)).thenReturn(optionalVaccine);

	  vaccineService.deleteVaccineCenter(vaccineEntity.getCenterId());

	 verify(vaccineRepository,times(1)).deleteById(centerId);
	}

	}

