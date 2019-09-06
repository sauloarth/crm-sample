package com.sabresit.crmsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabresit.crmsample.entity.Customer;
import com.sabresit.crmsample.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> costumers = service.getCustomers();
		model.addAttribute("customers", costumers);
		
		return "list-customers";
	}
}
