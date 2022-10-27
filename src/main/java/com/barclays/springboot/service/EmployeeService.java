package com.barclays.springboot.service;

import org.springframework.stereotype.Service;

import com.barclays.springboot.model.Employee;

@Service
public class EmployeeService {

	public Employee getEmployeeById(int employeeId) {
		Employee emp = new Employee(employeeId, "Sonu", 90000);
		System.out.println(emp.toString());
		return emp;
	}

}
