package com.luv2code.springdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	//need to inject the customer service
	@Autowired
	private CustomerService custService;
	//private CustomerDAO custDao; do not need CustomerDAO anymore, having Service layer now
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = custService.getCustomers(); //dont talk with dao directly anymore, using service now
		
		// add the customers to the model
		theModel.addAttribute("customeri", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormAdd")
	public String showForm(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("customerAttr", theCustomer);
		return "add-form";
	}
	
	@PostMapping("/processFormAdd")
	public String processForm(@ModelAttribute("customerAttr") Customer cust) {
		
		//save the customer using our service
		custService.addCustomer(cust);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int id, Model theModel) {
		
		//get the customer from our service
		Customer theCustomer = custService.getCustomer(id);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customerAttr", theCustomer);
		
		//send over to our form
		return "add-form";
		
	}
	
	@GetMapping("/showFormForDelete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		//delete the customer with our service
		custService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/searchForm")
	public String search(@RequestParam("theSearchName") String name, Model theModel) {
		
		//search for customers with given name
		List<Customer> customers = custService.searchCustomers(name);
		
		theModel.addAttribute("customeri", customers);
		
		return "list-customers";
	}

}
