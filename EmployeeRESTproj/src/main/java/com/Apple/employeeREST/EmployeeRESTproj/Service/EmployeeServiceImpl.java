package com.Apple.employeeREST.EmployeeRESTproj.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Apple.employeeREST.EmployeeRESTproj.DAO.EmployeeDAO;
import com.Apple.employeeREST.EmployeeRESTproj.Model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public void createEmploye(Employee employee) {
		employeeDAO.save(employee);
		
	}

	@Override
	public Employee readEmployee(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.findOne(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.save(employee);
		
		
	}

	@Override
	public void DeleteEmployee(String id) {
		employeeDAO.delete(id);
		
	}

	@Override
	public List<Employee> readEmployeesfromName(String name) {
		return employeeDAO.readEmployeesfromName(name);
	}

	@Override
	public List<Employee> searchEmployee(String name,String dept)
	{
		return employeeDAO.searchEmployee(name,dept);
	}
	@Override
	public List<Employee> getAllEmploye() {
		
		return employeeDAO.findAll();
		
	}

	@Override
	public List<Employee> readEmployeesbyDept(String dept) {
	
		return employeeDAO.readEmployeesbyDept(dept);
	}

}
