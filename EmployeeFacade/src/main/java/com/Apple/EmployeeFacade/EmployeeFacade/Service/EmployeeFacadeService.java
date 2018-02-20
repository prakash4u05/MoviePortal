package com.Apple.EmployeeFacade.EmployeeFacade.Service;



import java.util.List;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Apple.EmployeeFacade.EmployeeFacade.Model.Employee;

@Service
public interface EmployeeFacadeService {
	
	
	public Employee Getemployee(String id);
	public List<Employee> Getemployeebynameanddept(String dept,String name);
	public void createEmployee(Employee emp);
	public void updateEmployee(Employee emp);
}
