package com.sathya.springmvc.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
	String name;
	double salary;
	int age;
	String experience;
	String department;
	

}
