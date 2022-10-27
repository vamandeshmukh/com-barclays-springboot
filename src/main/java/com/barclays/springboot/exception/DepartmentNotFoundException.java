package com.barclays.springboot.exception;

public class DepartmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4587490826443438129L;

	public DepartmentNotFoundException() {
		super();
	}

	public DepartmentNotFoundException(String message) {
		super(message);
	}
}
