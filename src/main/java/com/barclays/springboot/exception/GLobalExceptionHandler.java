package com.barclays.springboot.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.barclays.springboot.model.Department;
import com.barclays.springboot.model.Employee;

@ControllerAdvice
public class GLobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Employee> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", e.getMessage());
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseEntity<Employee> response = new ResponseEntity<>(null, headers, status);
		return response;
	}

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Department> handleDepartmentNotFoundException(DepartmentNotFoundException e) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", e.getMessage());
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseEntity<Department> response = new ResponseEntity<>(null, headers, status);
		return response;
	}

	// other exception handlers

}
