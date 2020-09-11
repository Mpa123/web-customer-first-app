package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to Dependency inject session factory
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session sess = sf.getCurrentSession();
		
		//create query
		Query<Customer> q = sess.createQuery("from Customer", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = q.getResultList();
		
		//return the results   
		return customers;
	}
	
	

}
