package com.Apple.employeeREST.EmployeeRESTproj.controller;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Apple.employeeREST.EmployeeRESTproj.Model.Employee;
import com.Apple.employeeREST.EmployeeRESTproj.Service.EmployeeService;

/*Unit testcases for Employee controller restpoints*/
@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EmployeeService  employeeService;
	

	
	@Before
     public void setUp() throws Exception {
		
		Employee mockemp = new Employee("E02", "Spring", "kumar",21,"CS","2100","male");
		//Employee anothermockemp = new Employee("E03", "Rest", "kumar",22,"EEE","2000","female");
		List<Employee> mocklist = new ArrayList<>();
		mocklist.add(new Employee("E02", "Spring", "kumar",21,"CS","2100","male"));
		//mocklist.add(new Employee("E03", "Rest", "kumar",22,"EEE","2000","female"));
		
		Mockito.when(
				employeeService.readEmployee(Mockito.anyString()
					)).thenReturn(mockemp);
		Mockito.when(
				employeeService.searchEmployee(Mockito.anyString(),Mockito.anyString()
					)).thenReturn(mocklist);
		//Mockito.when(
				//employeeService.createEmploye(Mockito.any(Employee.class)).thenReturn();



		
		
	}

	@Test
	public void readEmployeetest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/SpringMongoREST/Employees/E02").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{'empid':'E02','fname':'Spring','lname':'kumar','age':21,'department':'CS','salary':'2100','gender':'male'}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), true);
	}

	@Test
	public void searchEmployeetest() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/SpringMongoREST/Employees/Search?name='prakash'&dept='CS'").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		String expected = "[{'empid':'E02','fname':'Spring','lname':'kumar','age':21,'department':'CS','salary':'2100','gender':'male'}]";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), true);
	}
	
	@Test
	public void createEmployeetest() throws Exception {
		//Employee anothermockemp = new Employee("E03", "Rest", "kumar",22,"EEE","2000","female");

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/SpringMongoREST/Employees/")
				.accept(MediaType.APPLICATION_JSON).content("{'empid':'E02','fname':'Spring','lname':'kumar','age':21,'department':'CS','salary':'2100','gender':'male'}")			
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		//assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/SpringMongoREST/Employees/E02",
				response.getHeader(HttpHeaders.LOCATION));
	}
	
}

