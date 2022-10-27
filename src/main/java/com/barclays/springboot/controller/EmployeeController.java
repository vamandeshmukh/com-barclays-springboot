package com.barclays.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.springboot.model.Employee;
import com.barclays.springboot.service.EmployeeService;

// http://localhost:8082/swagger-ui/index.html

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	// http://localhost:8082/emp/get-all-emps

	@GetMapping("/get-all-emps")
	public List<Employee> getAllEmps() {
		return empService.getAllEmployees();
	}

	@GetMapping("/get-emp-by-id/{eid}")
	public Employee findEmpById(@PathVariable(name = "eid") int employeeId) {
		return empService.getEmployeeById(employeeId);
	}

//	// http://localhost:8082/emp/add-emp
//	@PostMapping("/add-emp")
//	public Employee addEmp(@RequestBody Employee employee) {
//		return empService.addEmployee(employee);
//	}

	// http://localhost:8082/emp/add-emp
	@PostMapping("/add-emp")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
		Employee emp = empService.addEmployee(employee);
		HttpStatus status = HttpStatus.CREATED; // 201
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee with eid " + employee.getEmployeeId() + " added successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, status);
		return response;
	}

	// http://localhost:8082/update-emp

	@PutMapping("/update-emp")
	public Employee updateEmp(@RequestBody Employee employee) {
		return empService.updateEmployee(employee);
	}

	// http://localhost:8082/delete-emp/101

	@DeleteMapping("/delete-emp/{eid}")
	public Employee deleteEmp(@PathVariable(name = "eid") int employeeId) {
		return empService.deleteEmployee(employeeId);
	}

}
