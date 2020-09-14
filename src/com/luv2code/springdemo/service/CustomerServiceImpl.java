package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	//need to inject customer dao - because this service depends on customer dao
	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	@Transactional  //we want to define transaction at Service layer - Service layer will manage transactions
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers(); //DELEGATE calls to dao
	}
	
	@Override
	@Transactional
	public void addCustomer(Customer customer) {
	
		customerDao.addCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {

		return customerDao.getCustomer(id);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(int id) {
		
		customerDao.deleteCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String name) {
		
		return customerDao.searchCustomers(name);
	}
	

}
