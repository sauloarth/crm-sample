package com.sabresit.crmsample.dao;

import java.util.List;

import com.sabresit.crmsample.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);
}
