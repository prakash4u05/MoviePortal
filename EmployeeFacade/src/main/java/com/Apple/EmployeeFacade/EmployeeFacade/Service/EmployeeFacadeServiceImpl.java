package com.Apple.EmployeeFacade.EmployeeFacade.Service;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Apple.EmployeeFacade.EmployeeFacade.Model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeFacadeServiceImpl implements EmployeeFacadeService{

	//@Autowired
	//private RestTemplate restTemplate;
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	

	@Override
	public Employee Getemployee(String id) {
		//RestTemplate restTemplate = new RestTemplate();
		//Employee response = restTemplate().getForObject("http://localhost:8888/SpringMongoREST/Employees/"+id,Employee.class);
		ResteasyClient client = new ResteasyClientBuilder().build();

		            ResteasyWebTarget target = client
		                    .target("http://localhost:8888/SpringMongoREST/Employees/"+id);

		            Employee response = target.request().accept(MediaType.APPLICATION_JSON_VALUE).get(Employee.class);
	
		 

		
		
		return response;
	}

	@Override
	public List<Employee> Getemployeebynameanddept(String dept, String name) {
		//RestTemplate restTemplate = new RestTemplate();
		Employee[] response = restTemplate().getForObject("http://localhost:8888/SpringMongoREST/Employees/Search?name="+name+"&dept="+dept,Employee[].class);
		List<Employee> returnval = new ArrayList<Employee>(Arrays.asList(response));
		return returnval;
	}

	@Override
	public void updateEmployee(Employee emp) {
		//RestTemplate restTemplate = new RestTemplate();
		restTemplate().put("http://localhost:8888/SpringMongoREST/Employees/",emp,Employee.class);
		
	}
	
	@Override
	public void createEmployee(Employee emp) {
		//RestTemplate restTemplate = new RestTemplate();
		restTemplate().postForObject("http://localhost:8888/SpringMongoREST/Employees/",emp,Employee.class);
		
	}
	
	

}
