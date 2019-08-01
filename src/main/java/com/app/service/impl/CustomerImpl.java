package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Customer;
import com.app.model.Student;
import com.app.repo.CustomerRepository;
import com.app.service.ICustomerService;

@Service
public class CustomerImpl implements ICustomerService {

	@Autowired
	private CustomerRepository repo;
	
	@Transactional
	public Integer saveCustomer(Customer customer) {
				return  repo.save(customer).getCid();
	}

	@Transactional(readOnly = true)
	public List<Customer> getAllCustomer() {
		List<Customer> csm=repo.findAll();
		return csm;
	}

	@Transactional
	public void deleteCustomert(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Integer updateStudent(Customer customer) {
		Integer result = null;
		if(repo.save(customer)!=null)
			{
			 result=1;
			}
		return result;
	}

}
