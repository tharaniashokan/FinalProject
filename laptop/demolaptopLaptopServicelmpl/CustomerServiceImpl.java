package com.laptop.demolaptopLaptopServicelmpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import  com.laptop.demolaptopLaptop.Customer;
import   com.laptop.demolaptopResourceNotFound.Exception.ResourceNotFoundException;
import   com.laptop.demolaptopLaptopRepository.CustomerRepository;
import com.laptop.demolaptopLaptopServices.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	
	public CustomerServiceImpl(CustomerRepository  customerRepository) {
		super();
		this. customerRepository = customerRepository;
	}


	@Override
	public  Customer saveCustomer (Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
		
	}
// 4 - >Employee employee = {"john", "deo"}
// 12 - >Employee employee =  null
	@Override
	public  Customer getCustomerById(long id) {//4
		Optional<Customer> customer = customerRepository.findById(id);//4
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
          
			throw new ResourceNotFoundException("Customer","Id",id);
		}
		
	}


	@Override
	public  Customer updateCustomer(Customer customer , long id) {
		Customer cus = new Customer();
		
		 
	 try {
		 //orElseThrow();
		   cus = customerRepository.findById(id).orElseThrow(//4
				 ()-> 		 new ResourceNotFoundException("Customer","Id",id));
	} catch (Exception c) {
		
		c.printStackTrace();
	}
	  String fname = customer.getFirstName();
	 cus.setFirstName(fname);// a(cus)  - > A(employee)
	 
	 cus.setLastName(customer.getLastName());
	 cus.setEmail(cus.getEmail());
	 
	 customerRepository.save(cus);
	return cus;
	}


	@Override
	public void deleteCustomer(long id) {//13
		customerRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Customer","Id",id));
		
		 customerRepository.deleteById(id);//13
		
	}
	
	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {//john
				return customerRepository.findCustomerByFirstName(firstName);
	}


	@Override
	public List<Customer> getCustomerByLastName(String lastName) {// deo
		return customerRepository.findByLastName(lastName);
		
	}


	/*@Override
	public List<Employee> getEmployeesByIds(List<Long> idList) {
		return employeeRepository.findEmployeesByIds(idList);
	}*/


	
	@Override
	public List<Customer> getCustomerByFirstNameOrLastName(String firstName, String lastName) {
		return customerRepository.findByFirstNameOrLastName(firstName, lastName);
	}

// select * from employeeTbl where first_name="john" ANd last_name="doe"
	@Override
	public List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName) {
		return customerRepository.findByFirstNameAndLastName(firstName, lastName);
	}


	@Override
	public List<Customer> getCustomerById(List<Long> idList) {
		
		return null;//employeeRepository.findEmployeesById(idList);
	}


	@Override
	public Customer getCustomerFullNameById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> getCustomerInDescOrder() {
		// TODO Auto-generated method stub
		return null;
	}


	/*@Override
	public List<Employee> getEmployeeByDepartment(long id) {
		return employeeRepository.findByDepartmentId(id);
	}*/


	 


	 
 

}
