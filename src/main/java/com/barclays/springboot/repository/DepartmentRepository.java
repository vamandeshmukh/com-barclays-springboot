package com.barclays.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.springboot.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
