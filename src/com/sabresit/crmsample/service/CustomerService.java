package com.sabresit.crmsample.service;

import java.util.List;

import com.sabresit.crmsample.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCostumer(int id);

	public void deleteCustomer(int id);
}
