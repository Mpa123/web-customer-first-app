package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to Dependency inject session factory
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session sess = sf.getCurrentSession();
		
		//create query ... sort by last name
		Query<Customer> q = sess.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = q.getResultList();
		
		//return the results   
		return customers;
	}
	
	@Override
	public void addCustomer(Customer customer) {
		
		//get current hibernate session
		Session sess = sf.getCurrentSession();
		
		//save customer into DB
		sess.saveOrUpdate(customer); //if (primaryKey/id) empty then insert else update
		
	}
	
	@Override
	public Customer getCustomer(int id) {
		
		//get current hibernate session
		Session sess = sf.getCurrentSession();
		
		//get customer from DB
		Customer theCustomer = sess.get(Customer.class, id);
		
		//return customer
		return theCustomer;
		
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get current hibernate session
		Session sess = sf.getCurrentSession();
		
		//delete that customer
		Query q = sess.createQuery("delete from Customer where id=:theCustomerId");
		q.setParameter("theCustomerId", theId);
		
		q.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String name) {
		
		Session session = sf.getCurrentSession();
		Query<Customer> q = null;
		
		//only search by name if given name is not empty
		if(name != null && name.trim().length() > 0) {
		
			//search for firstName or lastName
			q = session.createQuery("from Customer where lower(firstName) like :theName"
					+ " or lower(lastName) like :theName", Customer.class);
			q.setParameter("theName", "%"+name.toLowerCase()+"%");
			
			if (!q.getResultList().isEmpty()) {
				return q.getResultList();
			}
			
		}
		
		//else name is not valid or not found in list, return all customers
		//create query ... sort by last name
		q = session.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = q.getResultList();
		
		//return the results   
		return customers;
	}
	
	

}
