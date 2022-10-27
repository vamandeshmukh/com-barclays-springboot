package com.barclays.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.springboot.model.Employee;
import com.barclays.springboot.service.EmployeeService;

//http://localhost:8082/swagger-ui/index.html

@RestController
public class EmployeeController {

//	EmployeeService empService = new EmployeeService();

	@Autowired
	EmployeeService empService;

	// http://localhost:8082/get-emp-by-id/101

	@GetMapping("get-emp-by-id/{eid}")
	public Employee findEmpById(@PathVariable(name = "eid") int employeeId) {
		return empService.getEmployeeById(employeeId);
	}

	@PostMapping("add-emp")
	public Employee addEmp(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}

}
