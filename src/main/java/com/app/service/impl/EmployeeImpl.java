package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import com.app.model.Item;
import com.app.repo.EmployeeRepository;
import com.app.service.IEmployeeService;

@Service
public class EmployeeImpl implements IEmployeeService {

	
	@Autowired
	private EmployeeRepository repo;
	
	@Transactional
	public Integer saveEmployee(Employee employee) {
		return  repo.save(employee).getEid();

	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		List<Employee> emp=repo.findAll();
		return emp;
	}

	@Transactional
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		Integer result = null;
		if(repo.save(employee)!=null)
			{
			 result=1;
			}
		return result;
	}

}
