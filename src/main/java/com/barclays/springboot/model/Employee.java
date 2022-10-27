package com.barclays.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "emp_table")
public class Employee {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // for other DBs
	@GenericGenerator(name = "emp_seq", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "first_name")
	@NotNull(message = "firstName can not be null.")
	@Size(min = 3, max = 40, message = "firstName should be min 3 and max 40 characters.")
	private String firstName;

	@Column(name = "salary")
	private double salary;

	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department deparetment;

	public Employee() {
		super();
	}

	public Employee(String firstName, double salary) {
		super();
		this.firstName = firstName;
		this.salary = salary;
	}

	public Employee(int employeeId, String firstName, double salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
	}

	public Employee(int employeeId, String firstName, double salary, Department department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
		this.deparetment = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDeparetment() {
		return deparetment;
	}

	public void setDeparetment(Department deparetment) {
		this.deparetment = deparetment;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", salary=" + salary
				+ ", deparetment=" + deparetment + "]";
	}

}
