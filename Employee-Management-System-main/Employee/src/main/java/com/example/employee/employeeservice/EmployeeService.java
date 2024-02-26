package com.example.employee.employeeservice;

import com.example.employee.employeeentity.EmployeeEntity;

public interface EmployeeService {
	public EmployeeEntity addemployee(EmployeeEntity employee);

	EmployeeEntity getemployeeById(String id);

	EmployeeEntity updatedemployeeById(EmployeeEntity updateemployee);
	void deleteemployeeById(String id);
}
