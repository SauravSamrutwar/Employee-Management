package com.example.employee.employeeentity;

import java.util.function.IntPredicate;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity*/
@Document(collection = "employees")

public class EmployeeEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
	 private String firstname;
	 private String lastname;
	 private String email;

	public String getSex() {
		return sex;
	}
	private String sex;
	 private String salary;
	 private String department;
	public EmployeeEntity(String id, String firstname, String lastname, String email, String sex, String salary, String department) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.sex = sex;
		this.salary = salary;
		this.department = department;
	}
	public EmployeeEntity() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeEntity{" +
				"id='" + id + '\'' +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", email='" + email + '\'' +
				", sex='" + sex + '\'' +
				", salary='" + salary + '\'' +
				", department='" + department + '\'' +
				'}';
	}

	
	 

	
		
	

}
