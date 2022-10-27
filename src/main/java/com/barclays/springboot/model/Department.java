package com.barclays.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dep_table")
public class Department {

	@Id
	private int departmentId;

	private String department_name;

	private String city;

}
