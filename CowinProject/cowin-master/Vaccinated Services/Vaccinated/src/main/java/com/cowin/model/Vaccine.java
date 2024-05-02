package com.cowin.model;

import java.time.LocalDate;

public class Vaccine {
	private int vaccineId;
	private String vaccineName;
	private LocalDate manufacureDate;
	private LocalDate expiryDate;
	private String companyName;

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public LocalDate getManufacureDate() {
		return manufacureDate;
	}

	public void setManufacureDate(LocalDate manufacureDate) {
		this.manufacureDate = manufacureDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
