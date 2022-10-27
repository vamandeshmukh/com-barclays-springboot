package com.barclays.springboot.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.springboot.exception.DepartmentNotFoundException;
import com.barclays.springboot.model.Department;
import com.barclays.springboot.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DepartmentRepository depRepository;

	public Department findDepartmentById(int departmentId) {

		Optional<Department> depOptional = depRepository.findById(departmentId);
		if (depOptional.isPresent())
			return depOptional.get();
		String errorMessage = "Department with did " + departmentId + " not found.";
		LOG.warn(errorMessage);
		throw new DepartmentNotFoundException(errorMessage);

	}

}
