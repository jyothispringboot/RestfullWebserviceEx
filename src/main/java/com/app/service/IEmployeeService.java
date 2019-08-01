package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeService {
	public Integer saveEmployee(Employee employee);
	//all
	public List<Employee> getAllEmployees();
	//delete
	public void deleteEmployee(Integer id);
	//update
	public Integer updateEmployee(Employee employee);


}
