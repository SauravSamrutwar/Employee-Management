package com.example.employeeservicetest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.employeeentity.EmployeeEntity;
import com.example.employee.employeeservice.EmployeeServiceimpl;

@ExtendWith(MockitoExtension.class)

class TestEmployeeService {
	
	private EmployeeDao Dao;
	 @Autowired
	private EmployeeServiceimpl employeeServiceimpl;

	@BeforeEach
	void setUp() {
		this.employeeServiceimpl = new EmployeeServiceimpl();
	}

	@Test

	void addemployee() {
		EmployeeServiceimpl t1 = new EmployeeServiceimpl();
		assertThat(t1.equals(123444));

	}

	@Test
	void getemployeeById() {
		EmployeeServiceimpl get = new EmployeeServiceimpl();
		assertThat(get.equals("123444"));
		//assertThat(get).isFalse();

	}

}
