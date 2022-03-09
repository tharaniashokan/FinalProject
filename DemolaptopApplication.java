package com.laptop.demolaptop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 import com.laptop.demolaptopLaptop.Laptop;
 import com.laptop.demolaptopLaptopController.LaptopController;
 import com.laptop.demolaptopLaptopRepository.LaptopRepository;
 import com.laptop.demolaptopLaptopServicelmpl.LaptopServiceImpl;
 import com.laptop.demolaptopLaptopServices.LaptopServices;
 import com.laptop.demolaptopResourceNotFound.ResourceNotFound;

@SpringBootApplication
public class DemolaptopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemolaptopApplication.class, args);
	}

}
