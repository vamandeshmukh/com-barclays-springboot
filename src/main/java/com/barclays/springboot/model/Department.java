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

	public Department() {
		super();
	}

	public Department(String department_name, String city) {
		super();
		this.department_name = department_name;
		this.city = city;
	}

	public Department(int departmentId, String department_name, String city) {
		super();
		this.departmentId = departmentId;
		this.department_name = department_name;
		this.city = city;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", department_name=" + department_name + ", city=" + city
				+ "]";
	}

}
