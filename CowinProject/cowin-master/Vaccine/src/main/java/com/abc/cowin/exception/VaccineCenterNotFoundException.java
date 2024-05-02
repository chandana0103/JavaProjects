package com.abc.cowin.exception;

@SuppressWarnings("serial")
public class VaccineCenterNotFoundException extends RuntimeException {

	public VaccineCenterNotFoundException(String msg) {
		super(msg);
	}
}
