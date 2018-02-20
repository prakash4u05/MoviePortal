package com.Apple.employeeREST.EmployeeRESTproj.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Apple.employeeREST.EmployeeRESTproj.Model.Employee;

@Service
public interface EmployeeService {
	
	public void createEmploye(Employee employee);
	public Employee readEmployee(String id);
	public void updateEmployee(Employee employee);
	public void DeleteEmployee(String id);
	public List<Employee> readEmployeesfromName(String name);
	public List<Employee> getAllEmploye();
	public List<Employee> readEmployeesbyDept(String dept);
	public List<Employee> searchEmployee(String name,String dept);
}
