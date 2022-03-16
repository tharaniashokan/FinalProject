package com.laptop.demolaptopLaptopController;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import  com.laptop.demolaptopLaptop.Customer;
import  com.laptop.demolaptopLaptopServices.CustomerService;

@RestController
@RequestMapping("/api/customer")// url

public class CustomerController {
	private CustomerService customerservice;
	
	 public CustomerController ( CustomerService customerservice) {
		 super();
		 this.customerservice= customerservice;

	 }
	 
	
	@PostMapping
	// saveEmployee(Employee obj)
	public ResponseEntity< Customer> saveCustomer(@RequestBody  Customer customer) {
		return new ResponseEntity< Customer>( customerservice.saveCustomer(customer),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List< Customer> getAllCustomer()
	{
		return customerservice.getAllCustomer();
	}
	
	@GetMapping("{id}")//4
	public ResponseEntity<Customer>getCustomerById(@PathVariable("id") long id) {
		return new ResponseEntity<Customer>(customerservice.getCustomerById(id), HttpStatus.OK);
	}
	
	@GetMapping("/customerByFirstName/{firstName}")//john
	public List<Customer> getCustomerByFirstName(@PathVariable("firstName")String firstName){
		return customerservice.getCustomerByFirstName(firstName);//john
	}
	
	@GetMapping("/customerByLastName/{lastName}")//doe
	public List<Customer> getCustomerByLastName(@PathVariable("lastName") String lastName){
		return customerservice.getCustomerByLastName(lastName);//deo
		
	}
	
		@GetMapping("/customerByFirstNameAndLastName")
	public List<Customer> getCustomerByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
	{
		return customerservice.getCustomerByFirstNameAndLastName(firstName, lastName);
		
	}
	

	@GetMapping("/customerByFirstNameOrLastName")
	public List<Customer> getCustomerByFirstNameOrLastName(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")  String lastName )
	{
		return customerservice.getCustomerByFirstNameOrLastName(firstName, lastName);
		
	}
	
	@GetMapping("/customerByIds")
	public List<Customer> getCustomerByIds(@RequestParam(value="id") List<Long> id){
		return  customerservice.getCustomerById(id);
	}
	
	/*@GetMapping("/employeeByDepartment/{id}")
	public List<Employee> getemployeeByDepartment(@PathVariable("id") Long id){
		return employeeService.getEmployeeByDepartment(id);
		
	}*/
	
	 
	@GetMapping("/customerFullNameById/{id}")
	public Customer getCustomerFullNameById( @PathVariable("id") long id){
		return customerservice.getCustomerFullNameById(id);
	}
	
		@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
		
		return new ResponseEntity<Customer>(customerservice.updateCustomer(customer, id),HttpStatus.OK);
		
	}
		
	@GetMapping("/customerInDescOrder")
	public List<Customer> getCustomerInDescOrder(){
		return customerservice.getCustomerInDescOrder();
	}

	// CRUD
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
		customerservice.deleteCustomer(id);
		return new ResponseEntity<String>("Customerr record deleted ",HttpStatus.OK);
		
	}
	
	
	
	
}
