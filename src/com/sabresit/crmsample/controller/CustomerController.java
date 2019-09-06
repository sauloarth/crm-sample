package com.sabresit.crmsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabresit.crmsample.dao.CustomerDAO;
import com.sabresit.crmsample.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO dao;

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> costumers = dao.getCustomers();
		model.addAttribute("customers", costumers);
		
		return "list-customers";
	}
}
