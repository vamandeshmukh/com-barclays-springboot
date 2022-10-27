package com.barclays.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.springboot.model.Employee;
import com.barclays.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> empOptional = empRepository.findById(employeeId);
		Employee emp = empOptional.get();
		System.out.println(emp.toString());
		return emp;
	}

	public Employee addEmployee(Employee employee) {
		System.out.println(employee.toString());
		return empRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		System.out.println(employee.toString());
		return empRepository.save(employee);
	}

	public Employee deleteEmployee(int employeeId) {
		System.out.println(employeeId);
		empRepository.deleteById(employeeId);
		return null;
	}

}
