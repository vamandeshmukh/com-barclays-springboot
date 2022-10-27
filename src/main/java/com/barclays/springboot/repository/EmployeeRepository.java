package com.barclays.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// repository provides methods for basic CRUD operations -
	// INSERT - save();
	// UPDATE - save();
	// DELETE - deleteById();
	// SELECT one - findById();
	// SELECT all - findAll();
	// No need to declare methods for these operations.

	// syntax
//	public abstract Object findByFieldName(Object fieldName);

	public abstract List<Employee> findByFirstName(String firstName);

	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

}
