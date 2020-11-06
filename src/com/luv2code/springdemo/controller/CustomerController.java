package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject our service into controller
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		//get customers from dao
		List<Customer> theCustomer = customerService.getCustomers();
		
		//add the customers to the model 
		theModel.addAttribute("customers", theCustomer);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		return "customer-add";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		//get id from customer service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//add the customer of the desired primary key to model attribute
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-add";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId,
						Model theModel) {
		//get the id from customer service
		customerService.getDelete(theId);
		
		return "redirect:/customer/list";
	}
}
