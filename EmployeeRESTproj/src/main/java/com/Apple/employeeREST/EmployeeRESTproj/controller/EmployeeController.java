package com.Apple.employeeREST.EmployeeRESTproj.controller;

import java.util.List;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Apple.employeeREST.EmployeeRESTproj.DAO.EmployeeDAO;
import com.Apple.employeeREST.EmployeeRESTproj.Model.Employee;
import com.Apple.employeeREST.EmployeeRESTproj.Service.EmployeeService;
import com.Apple.employeeREST.EmployeeRESTproj.Service.EmployeeServiceImpl;



/*Employee Controller*/

@CrossOrigin(origins = "http://localhost:9999")
@RestController
@RequestMapping("/SpringMongoREST/Employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	/*Rest end point for getting  All records*/
	@RequestMapping(method= RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllemployee()
	{
		return employeeService.getAllEmploye();
		
	}
	
	/*Rest end point for creating resource*/
	
	@RequestMapping(method= RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Response createEmploye(@RequestBody Employee employee)
	{
		employeeService.createEmploye(employee);
		return Response.status(201).build(); 
		
	}
	
	/*Rest end point for getting single employee*/
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee readEmployee(@PathVariable String id)
	{
		//System.out.println("check");
		return employeeService.readEmployee(id);
		
		
	}
	
	/*Rest end point for getting based on name
	@RequestMapping(value="/name/{name}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> readEmployeebyName(@PathVariable String name)
	{
		return employeeService.readEmployeesfromName(name);
		
		
	}
	
	Rest end point for getting based on department
	@RequestMapping(value="/dept/{dept}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> readEmployeebyDept(@PathVariable String dept)
	{
		return employeeService.readEmployeesbyDept(dept);
		
		
	}*/
	
	/*Rest end point for getting based on department*/
	@RequestMapping(value="/Search",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> SearchEmployee(@QueryParam("dept") String dept,@QueryParam("name") String name)
	{
		

		//System.out.println(name+dept);
		return employeeService.searchEmployee(name, dept);
		
		
	}
	
	/*Rest end point for updating the resource*/
	@RequestMapping(method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@RequestBody Employee employee)
	{
		employeeService.updateEmployee(employee);
	}
	
	/*Rest end point for deleting the resource*/
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public void DeleteEmployee(@PathVariable String id)
	{
		employeeService.DeleteEmployee(id);
	}
	
	

}
