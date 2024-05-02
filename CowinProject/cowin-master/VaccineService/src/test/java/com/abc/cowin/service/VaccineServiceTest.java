package com.abc.cowin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.cowin.entity.VaccineEntity;
import com.abc.cowin.exception.VaccineNotFoundException;
import com.abc.cowin.model.Vaccine;
import com.abc.cowin.repository.VaccineRepository;
import com.abc.cowin.util.EntityModelUtil;

@SpringBootTest
public class VaccineServiceTest {

	@InjectMocks
	private VaccineService vaccineService = new VaccineServiceImpl();

	@Mock
	private VaccineRepository vaccineRepository;

	@Test
	public void deleteVaccineById() {
		VaccineEntity vaccine = new VaccineEntity();
		vaccine.setVaccineId(0);
		vaccine.setVaccineName(" ");
		vaccine.setManufactureDate(LocalDate.of(2000, 10, 10));
		vaccine.setExpiryDate(LocalDate.of(2020, 10, 10));
		vaccine.setCompanyName(" ");

		Optional<VaccineEntity> optionalVaccine = Optional.of(vaccine);
		int vaccineId = 4;

		when(vaccineRepository.findById(4)).thenReturn(optionalVaccine);

		Vaccine existingVaccine = vaccineService.getVaccineById(vaccineId);

		assertEquals(vaccine.getVaccineId(), existingVaccine.getVaccineId());
	}
/*	@Test
	public void testSaveVaccine() {
		Vaccine vaccine = new Vaccine();
		vaccine.setVaccineId(0);
		vaccine.setVaccineName(" ");
		vaccine.setManufactureDate(LocalDate.of(2000, 10, 19));
		vaccine.setExpiryDate(LocalDate.of(2020, 10, 10));
		vaccine.setCompanyName(" ");
		
		VaccineEntity vaccineEntity = EntityModelUtil.vaccineModelToEntity(vaccine);
		when(vaccineRepository.save(vaccineEntity)).thenReturn(vaccineEntity);
		Vaccine newVaccine = vaccineService.saveVaccine(vaccine);
		assertEquals(vaccine.getVaccineId(), newVaccine.getVaccineId());
	}*/

	@Test
	public void testGetVaccineById() {

		VaccineEntity vaccine = new VaccineEntity();
		vaccine.setVaccineId(0);
		vaccine.setVaccineName(" ");
		vaccine.setManufactureDate(LocalDate.of(2000, 10, 10));
		vaccine.setExpiryDate(LocalDate.of(2020, 10, 10));
		vaccine.setCompanyName(" ");

		Optional<VaccineEntity> optionalVaccine = Optional.of(vaccine);
		int vaccineId = 2;

		when(vaccineRepository.findById(2)).thenReturn(optionalVaccine);

		Vaccine existingVaccine = vaccineService.getVaccineById(vaccineId);

		assertEquals(vaccine.getVaccineId(), existingVaccine.getVaccineId());

	}
	@Test
	public void testGetVaccineByIdNotFound() {

		int vaccineId = 20;

		when(vaccineRepository.findById(vaccineId)).thenThrow(VaccineNotFoundException.class);

		assertThrows(VaccineNotFoundException.class, () -> vaccineService.getVaccineById(vaccineId));

	}

}
