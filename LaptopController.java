package com.laptop.demolaptopLaptopController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.laptop.demolaptopLaptop.Laptop;
import    com.laptop.demolaptopLaptopServices.LaptopServices;
@RestController
@RequestMapping("/api/laptopshop")
public class LaptopController {
	private LaptopServices laptopService;

	public  LaptopController( LaptopServices  LaptopService) {
		super();
		this. laptopService = laptopService;
	}
	
	@PostMapping
	// saveEmployee(Employee obj)
	public ResponseEntity<Laptop> saveLaptop(@RequestBody Laptop laptop) {
		return new ResponseEntity<Laptop>(laptopService.saveLaptop(laptop),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Laptop> getAllLaptop()
	{
		return laptopService.getAllLaptop();
	}
	
	@GetMapping("{id}")//4
	public ResponseEntity<Laptop>getlaptopById(@PathVariable("id") long id) {
		return new ResponseEntity<Laptop>(laptopService.getLaptopById(id), HttpStatus.OK);
	}
	
	@GetMapping("/laptopByLaptopColor/{laptopcolor}")//red
	public List<Laptop> getLaptopByLaptopColor(@PathVariable("laptopcolor")String laptopcolor){
		return laptopService.getLaptopByLaptopColor(laptopcolor);//john
	}
	
	@GetMapping("laptopByLaptopCompany/{laptopcompany}")//doe
	public List<Laptop> getLaptopByLaptopCompany(@PathVariable("laptopcompany") String laptopcompany){
		return laptopService.getLaptopByLaptopCompany(laptopcompany);//deo
		
	}
	
	

	 
	
	/*@GetMapping("/employeeByDepartment/{id}")
	public List<Employee> getemployeeByDepartment(@PathVariable("id") Long id){
		return employeeService.getEmployeeByDepartment(id);
		
	}*/
	
	 
	
		@PutMapping("{id}")
	public ResponseEntity<Laptop> updateLaptop(@PathVariable("id") long id, @RequestBody Laptop laptop ){
		
		return new ResponseEntity<Laptop>(laptopService.updateLaptop(laptop, id),HttpStatus.OK);
		
	}
		
	@GetMapping("/laptopInDescOrder")
	public List<Laptop> getLaptopInDescOrder(){
		return laptopService.getLaptopInDescOrder();
	}

	// CRUD
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLaptop(@PathVariable("id") long id){
		laptopService.deleteLaptop(id);
		return new ResponseEntity<String>("Laptop record deleted ",HttpStatus.OK);
		
	}
	
	
	
	
}
