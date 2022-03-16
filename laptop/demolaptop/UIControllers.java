package com.laptop.demolaptop;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

 
import com.laptop.demolaptopLaptop.Customer;   
 
import  com.laptop.demolaptopLaptopServices.CustomerService;
 

@Controller
public class UIControllers {
	
	private CustomerService customerService;
	
	
	
@Autowired	
public UIControllers(CustomerService customerService ) {
		super();
		this.customerService = customerService;
		 
	}

@GetMapping("/")
	
	String index() {
		return "index";/// index.html
	}

// Employee 
@GetMapping("/registration")
public String cusRegistrationForm(Model model) {
	Customer customer = new Customer();
	
	 
	model.addAttribute("customer", customer);
    return "add-customer";
}

@PostMapping("/saveCustomer")
public String saveCustomer(@Valid  Customer customer, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    customerService.saveCustomer(customer);
	List<Customer> customers =  customerService.getAllCustomer();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getCustomers";
    
}

@GetMapping("/getCustomers")
public String getAllCustomer(Model model) {
	
	List<Customer> customers =  customerService.getAllCustomer();
	
	model.addAttribute("customers", customers);
	
    return "list-customer";}



// Department 

 

 
}


