package com.abc.cowin.exception;

@SuppressWarnings("serial")
public class VaccineNotFoundException extends RuntimeException {

	public VaccineNotFoundException(String msg) {
		super(msg);
	}
}
