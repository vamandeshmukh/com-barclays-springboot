package com.barclays.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// no need to declare methods for basic CRUD ops
	// SELECT - findAll();
	// SELECT - findById();
	// INSERT - save();
	// UPDATE - save();
	// DELETE - deleteById();

}
