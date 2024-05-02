package com.abc.appointmentservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.appointmentservice.entity.AppointmentEntity;
import com.abc.appointmentservice.model.Appointment;
import com.abc.appointmentservice.model.AppointmentDetails;
import com.abc.appointmentservice.repository.AppointmentRepository;
import com.abc.appointmentservice.service.AppointmentService;
import com.abc.appointmentservice.service.AppointmentServiceImpl;
import com.abc.appointmentservice.util.AppointmentUtil;

@SpringBootTest(classes = AppointmentTest.class)
public class AppointmentTest {

	@InjectMocks
	AppointmentService appointmentService = new AppointmentServiceImpl();
	
	@Mock
	private UserService userService;
	
	 @Mock 
	 private VaccinationCenterService vaccinationCenterService;
	 

	@Mock
	private AppointmentRepository appointmentRepository;

	@Mock
	private AppointmentUtil appointmentUtil;

	@Test
	public void testBookAppointment() {

		Appointment appointment = new Appointment();
		appointment.setAppointmentId(110);
		appointment.setCenterId(10);
		appointment.setDateOfAppointment(LocalDate.of(2020, 10, 12));
		appointment.setDoseNumber(2);
		appointment.setTypeOfVaccine("pfizer");
		appointment.setUserId(110);

		AppointmentEntity appointmentEntity = new AppointmentEntity();
		appointmentEntity.setAppointmentId(appointment.getAppointmentId());
		appointmentEntity.setCenterId(appointment.getCenterId());
		appointmentEntity.setDateOfAppointment(appointment.getDateOfAppointment());
		appointmentEntity.setDoseNumber(appointment.getDoseNumber());
		appointmentEntity.setTypeOfVaccine(appointment.getTypeOfVaccine());
		appointmentEntity.setUserId(appointment.getUserId());

		when(appointmentUtil.appointmentModelToEntity(appointment)).thenReturn(appointmentEntity);

		when(appointmentUtil.appointmentEntityToModel(appointmentEntity)).thenReturn(appointment);

		when(appointmentRepository.save(appointmentEntity)).thenReturn(appointmentEntity);

		assertEquals(appointmentEntity.getAppointmentId(), appointment.getAppointmentId());
	}

	@Test
	public void testCancelAppointment() {

		int appointmentId = 3;
		AppointmentEntity appointmentEntity = new AppointmentEntity();

		appointmentEntity.setAppointmentId(3);
		appointmentEntity.setCenterId(122);
		appointmentEntity.setDateOfAppointment(LocalDate.of(2020, 10, 12));
		appointmentEntity.setDoseNumber(1);
		appointmentEntity.setTypeOfVaccine("Covaxin");
		appointmentEntity.setUserId(10);

		Optional<AppointmentEntity> optional = Optional.of(appointmentEntity);
		when(appointmentRepository.findById(3)).thenReturn(optional);
		appointmentService.cancelAppointment(appointmentEntity.getAppointmentId());
		verify(appointmentRepository, times(1)).deleteById(appointmentId);
	}

	@Test
	public void testViewAppointment() {
		AppointmentEntity appointmentEntity = new AppointmentEntity();
		appointmentEntity.setAppointmentId(4);
		appointmentEntity.setCenterId(122);
		appointmentEntity.setDateOfAppointment(LocalDate.of(2020, 10, 12));
		appointmentEntity.setDoseNumber(1);
		appointmentEntity.setTypeOfVaccine("Covaxin");
		appointmentEntity.setUserId(10);
		
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(4);
		appointment.setCenterId(10);
		appointment.setDateOfAppointment(LocalDate.of(2020, 10, 12));
		appointment.setDoseNumber(2);
		appointment.setTypeOfVaccine("pfizer");
		appointment.setUserId(110);

		int appointmentId = 4;
		Optional<AppointmentEntity> optional = Optional.of(appointmentEntity);
		when(appointmentUtil.appointmentModelToEntity(appointment)).thenReturn(appointmentEntity);

		when(appointmentUtil.appointmentEntityToModel(appointmentEntity)).thenReturn(appointment);

		when(appointmentRepository.findById(4)).thenReturn(optional);

		AppointmentDetails existing = appointmentService.viewAppointmentdetails(appointmentId);

		assertEquals(appointmentEntity.getAppointmentId(), existing.getAppointment().getAppointmentId());
	}


}
