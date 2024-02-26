package com.example.employee.dao;

import java.util.Optional;
import java.util.function.IntPredicate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.employeeentity.EmployeeEntity;
import com.example.employee.employeeservice.EmployeeServiceimpl;

@Repository
public interface EmployeeDao extends MongoRepository<EmployeeEntity, String> {

	Optional<EmployeeEntity> findById(String id);

	

	//void save();

	
	

	

	//void saveEmployeeTest(String string);


	
	


	



	

	

	
	
	

}