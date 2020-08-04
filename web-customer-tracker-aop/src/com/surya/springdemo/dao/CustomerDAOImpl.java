package com.surya.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.surya.springdemo.entity.Customer;

//add component scan like @Controller to support spring DI
@Repository                                              
public class CustomerDAOImpl implements CustomerDAO {
	
	//inject session factory from spring config
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName",Customer.class);
		
		List<Customer> customerList = theQuery.getResultList();
		
		return customerList;
	}



	@Override
	public void save(Customer theCustomer) {

     Session session = sessionFactory.getCurrentSession();
     
     session.saveOrUpdate(theCustomer);
		
	}



	@Override
	public Customer getCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, theId);
		
				
		return customer;


	}



	@SuppressWarnings("rawtypes")
	@Override
	public void deleteCustomer(int theId) {

		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id = :customerId");
		
		query.setParameter("customerId", theId);
		
		query.executeUpdate();
		
		
	}



	@Override
	public List<Customer> searchCustomers(String searchName) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = null;
		
		if(searchName != null && searchName.trim().length() > 0) {
			query = session.createQuery("from Customer where lower(firstName) like :theName or"
					+ " lower(lastName) like :theName", Customer.class);
			
			query.setParameter("theName", "%"+searchName.toLowerCase()+"%");
		}
		else {
			query = session.createQuery("from Customer order by lastName", Customer.class);
		}
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
