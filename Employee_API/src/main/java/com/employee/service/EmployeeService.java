package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(Long id);
	
	public Employee updateEmployee(Employee employee, Long id);
	
	public void deleteEmployee(Long id);
	
}
