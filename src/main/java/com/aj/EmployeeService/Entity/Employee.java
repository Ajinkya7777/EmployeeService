package com.aj.EmployeeService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //(@Setter,@Getter,@toString())
//@Setter
//@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name="emp_salary")
	private int empSal;
	@Column(name="emp_mail")
	private String empMail;
	
}
