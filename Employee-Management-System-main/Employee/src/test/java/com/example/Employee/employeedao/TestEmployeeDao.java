package com.example.Employee.employeedao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.employee.dao.EmployeeDao;

import com.example.employee.employeeentity.EmployeeEntity;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class TestEmployeeDao {
	@Autowired

	private EmployeeDao employeeDao;

//testing for savedemployee
	@Test
	 @Order(value = 1)
	@Rollback(false) // to disable roll back to the data will be committed to the database and
						// available for the next test methods which will run separately.
	void saveEmployeeandFindEmployeeTest() {
		EmployeeEntity employee = new EmployeeEntity();

		employee.setId("13");
		employee.setFirstname("ashwini");
		employee.setLastname("sangale");
		employee.setEmail("ashu123@gmal.com");
		employeeDao.save(employee);
		assertNotNull(employeeDao.findById("13").get());
		assertEquals("13", employee.getId());
		// assertNull(employee);//failed because employee is not null
		assertTrue(" if Employee is present then its true ", true);
		assertTrue(" if Employee is  not present then its false  ", false);

	}

	private void assertTrue(String string, boolean b) {
		// TODO Auto-generated method stub

	}

      @Test
      @Order(value = 2)
        void updatedemployee() {
    	  EmployeeEntity employee = employeeDao.findById("13").get();
    	  employee.setFirstname("ashsii");
    	  employeeDao.save(employee);
    	  assertNotEquals("ashwini", employeeDao.findById("13").get().getFirstname());
      }
        @Test
        @Order(value = 3)
       void deleteemployee() {
        	
        	employeeDao.deleteById("13");
        	assertThat(employeeDao.existsById("13")).isFalse();

        	//assertThat(employeeDao.existsById("13")).isTrue();
        	
        }
}
