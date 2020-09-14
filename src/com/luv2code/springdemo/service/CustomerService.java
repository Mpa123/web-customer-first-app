package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
	
	public void addCustomer(Customer theCustomer);
	
	public void deleteCustomer(int id);
	
	public List<Customer> searchCustomers(String name);
	

}