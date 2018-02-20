package com.Apple.employeeREST.EmployeeRESTproj.DAO;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Apple.employeeREST.EmployeeRESTproj.Model.Employee;


@RunWith(SpringRunner.class)
@DataMongoTest
public class EmployeeDAOTest {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testReadEmployeesfromName() {
//		List<Employee> empoptional = employeeDAO.readEmployeesfromName("prakash");
//		System.out.println(empoptional.get(0).getEmpid());
//		assertEquals("E03",empoptional.get(0).getEmpid());
//	}

	@Test
	public void testReadEmployeesbyDept() {
		
		List<Employee> empoptional = employeeDAO.readEmployeesbyDept("CS");
		System.out.println(empoptional.get(0).getEmpid());
		assertEquals("E02",empoptional.get(0).getEmpid());
	
	}

}
