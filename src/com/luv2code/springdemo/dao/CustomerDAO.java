package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
	
	public void addCustomer(Customer customer);
	
	public void deleteCustomer(int id);
	
	public List<Customer> searchCustomers(String name);

}
