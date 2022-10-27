package com.barclays.springboot.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6849161022192427465L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
