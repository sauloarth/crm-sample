package com.sabresit.crmsample.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sabresit.crmsample.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class); 
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = 
				session.createQuery("delete from Customer where id=:customerId")
				.setParameter("customerId", id);
		
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String searchName) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = null;
		
		if(searchName != null && searchName.trim().length() != 0) {
			query = session
					.createQuery("from Customer" + 
							" where lower(firstName) LIKE :searchName " + 
							" OR lower(lastName) LIKE :searchName order by lastName", Customer.class)
					.setParameter("searchName", "%" + searchName.toLowerCase() + "%");
		} else {
			query = session
					.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
