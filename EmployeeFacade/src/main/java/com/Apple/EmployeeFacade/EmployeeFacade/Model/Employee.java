package com.Apple.EmployeeFacade.EmployeeFacade.Model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	
	

	public Employee() {
		
	}
	public Employee(String empid, String fname, String lname, int age, String department, String salary,
			String gender) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.department = department;
		this.salary = salary;
		Gender = gender;
	}
	@Id
	private String empid;
	@NotNull
	private String fname;
	private String lname;
	private int age;
	private String department;
	private String salary;
	private String Gender;
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Gender == null) ? 0 : Gender.hashCode());
		result = prime * result + age;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((empid == null) ? 0 : empid.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Gender == null) {
			if (other.Gender != null)
				return false;
		} else if (!Gender.equals(other.Gender))
			return false;
		if (age != other.age)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (empid == null) {
			if (other.empid != null)
				return false;
		} else if (!empid.equals(other.empid))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
	
}
