package com.journaldev.jaxrs.dao;

import java.util.List;

import javax.ws.rs.core.Response;

import com.journaldev.jaxrs.model.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(int i, Employee e);
	
	public void deleteEmployee(int id);
	
	public Employee getEmployee(int id);
	
	public List<Employee> getAllEmployees();
	

}
