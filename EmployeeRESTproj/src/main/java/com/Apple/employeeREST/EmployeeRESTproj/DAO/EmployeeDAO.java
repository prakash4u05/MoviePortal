package com.Apple.employeeREST.EmployeeRESTproj.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.Apple.employeeREST.EmployeeRESTproj.Model.Employee;

@org.springframework.stereotype.Repository
public interface EmployeeDAO extends MongoRepository<Employee, String>{

	/*Method to get employees based on name*/
	@Query("{ 'fname' : ?0 }")
	List<Employee> readEmployeesfromName(String name);

	/*Method to get employees based on department*/
	@Query("{ 'department' : ?0 }")
	List<Employee> readEmployeesbyDept(String department);
	//@Query("{'fname' : ?0 },{ 'department' : ?1 }")
	
	@Query("{'$or':[{'fname': ?0 },{'department' :?1}]}")
	List<Employee> searchEmployee(String name,String department);
	
	

}
