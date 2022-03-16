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

 
import  com.laptop.demolaptopLaptop.Laptop;
 
import  com.laptop.demolaptopLaptopServices.LaptopServices;
 

@Controller
public class UIController {
	
	private LaptopServices laptopService;
	 
	
	
@Autowired	
public UIController(LaptopServices  laptopServices ) {
		super();
		this.laptopService = laptopServices;
		 
	}

@GetMapping("/")
	
	String index() {
		return "index";/// index.html
	}

// Employee 
@GetMapping("/registration")
public String empRegistrationForm(Model model) {
	Laptop laptop = new Laptop();
	model.addAttribute("laptop",laptop);
    return "add-laptop";
}

@PostMapping("/saveLaptop")
public String saveLaptop(@Valid  Laptop laptop, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    laptopService.saveLaptop(laptop);
	List< Laptop>  laptops = laptopService.getAllLaptop();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getEmployees";
    
}

@GetMapping("/getLaptop")
public String getAllLaptop(Model model) {
	
	List<Laptop> laptops =  laptopService.getAllLaptop();
	
	model.addAttribute(" laptops",  laptops);
	
    return "list-laptop";}



// Department 

 

 
        }
    



