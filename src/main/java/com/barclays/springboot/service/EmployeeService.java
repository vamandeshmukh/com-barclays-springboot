package com.barclays.springboot.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.springboot.exception.EmployeeNotFoundException;
import com.barclays.springboot.model.Employee;
import com.barclays.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		return empRepository.findAll();
	}

	public Employee getEmployeeById(int employeeId) { //
		LOG.info("getEmployeeById " + employeeId);
		Optional<Employee> empOptional = empRepository.findById(employeeId);
		if (empOptional.isPresent())
			return empOptional.get();
		String errorMessage = "Employee with eid " + employeeId + " not found.";
		LOG.warn(errorMessage);
		throw new EmployeeNotFoundException(errorMessage);
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		List<Employee> empList = empRepository.findByFirstName(firstName);
		if (!empList.isEmpty())
			return empList;
		String errorMessage = "Employees with the name " + firstName + " not found.";
		LOG.warn(errorMessage);
		throw new EmployeeNotFoundException(errorMessage);
	}

	public Employee addEmployee(Employee employee) {
		LOG.info("addEmployee " + employee.toString());
		return empRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		LOG.info("updateEmployee " + employee.toString());
		this.getEmployeeById(employee.getEmployeeId());
		return empRepository.save(employee);
	}

	public Employee deleteEmployee(int employeeId) {
		Employee emp = this.getEmployeeById(employeeId);
		LOG.info("deleteEmployeeById " + employeeId);
		empRepository.deleteById(employeeId);
		return emp;
	}
}