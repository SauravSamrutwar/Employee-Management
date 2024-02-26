package com.example.employee.employeeservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.employee.dao.EmployeeDao;
import com.example.employee.employeeentity.EmployeeEntity;

@Service

public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public EmployeeEntity addemployee(EmployeeEntity employee) {
		return employeeDao.save(employee);

	}
	
	public List<EmployeeEntity> getAllEmployee(){
		List<EmployeeEntity> employees = employeeDao.findAll();
		return employees;
	}

	public String checkPassword(String id, String password) {
		if (id.length() > 0) {
			if (id.equals("sourabh")) {
				if (password.equals("abcd123")) {
					return "authPass"; // Correct credentials
				} else {
					return "Incorrect Password";
				}
			} else {
				return "User does not exist"; // Handle non-existent user
			}
		} else {
			return "Invalid input"; // Handle empty ID
		}
	}

	@Override
	public EmployeeEntity getemployeeById(String id) {
		Optional<EmployeeEntity> employeeData = employeeDao.findById(id);

		if (employeeData.isPresent()) {
			return employeeData.get();
		} else {
		}
		return null;

	}

	@Override
	public EmployeeEntity updatedemployeeById( EmployeeEntity updateemployee ) {

		return employeeDao.save(updateemployee);
	}
	
	@Override
	public void deleteemployeeById(String id) {
		EmployeeEntity employeeentity = getemployeeById(id);
		
		employeeDao.deleteById(employeeentity.getId());
		
	}


}