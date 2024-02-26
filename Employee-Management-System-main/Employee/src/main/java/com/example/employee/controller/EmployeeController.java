package com.example.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employee.employeeentity.EmployeeEntity;
import com.example.employee.employeeservice.EmployeeServiceimpl;


@RestController
@RequestMapping("/lms")

public class EmployeeController {
	@Autowired
	EmployeeServiceimpl employeeService;

	@PostMapping("/employee")
	public EmployeeEntity employeedata(@RequestBody EmployeeEntity employee) {
		return employeeService.addemployee(employee);

	}
	
	@GetMapping("/employee")
	public List<EmployeeEntity> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/home")
	public String home(){
		return "Hello";
	}

	@GetMapping("/employee/{id}")

	public EmployeeEntity getemployeedata(@PathVariable(value = "id") String id) {
		return employeeService.getemployeeById(id);

	}
	
	//@CrossOrigin
	@GetMapping("/checkAuth")
	public String getEmployeeData(@RequestParam(value = "id") String id,
								  @RequestParam(value = "password") String password) {
		// Your existing logic here
		System.out.println("Received request for ID: " + id);
		return employeeService.checkPassword(id, password);
	}


	@PutMapping("/edit/{id}")
	public EmployeeEntity updatedemployeedata (@RequestBody EmployeeEntity updateemployee ){
		return employeeService.updatedemployeeById(updateemployee) ;

	}
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteemployeedata(@PathVariable(value = "id") String id){
		employeeService.deleteemployeeById(id) ;
		return new ResponseEntity<>("Employee data Deleted Successfully", HttpStatus.OK);

	}

}
