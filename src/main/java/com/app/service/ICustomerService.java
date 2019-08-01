package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {
	
	public Integer saveCustomer(Customer customer);
	//all
	public List<Customer> getAllCustomer();
	//delete
	public void deleteCustomert(Integer id);
	//update
	public Integer updateStudent(Customer customer);

}
