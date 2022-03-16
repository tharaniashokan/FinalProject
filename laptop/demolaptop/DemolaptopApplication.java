package com.laptop.demolaptop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 import com.laptop.demolaptopLaptop.Customer;
 import com.laptop.demolaptopLaptopController.CustomerController;
 import com.laptop.demolaptopLaptopRepository.CustomerRepository;
 import com.laptop.demolaptopLaptopServicelmpl.CustomerServiceImpl;
 import com.laptop.demolaptopLaptopServices.CustomerService;
 import  com.laptop.demolaptopResourceNotFound.Exception.ResourceNotFoundException;
 import  com.laptop.demolaptop.UIControllers;

@SpringBootApplication
public class DemolaptopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemolaptopApplication.class, args);
	}

}
