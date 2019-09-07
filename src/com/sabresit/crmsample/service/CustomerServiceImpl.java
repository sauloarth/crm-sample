package com.sabresit.crmsample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sabresit.crmsample.dao.CustomerDAO;
import com.sabresit.crmsample.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO dao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return dao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCostumer(int id) {
		return dao.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchName) {
		return dao.searchCustomers(searchName);
	}

}
