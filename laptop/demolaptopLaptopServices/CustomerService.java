package com.laptop.demolaptopLaptopServices;

import java.util.List;

import  com.laptop.demolaptopLaptop.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer getCustomerById(long id);
	Customer updateCustomer(Customer customer,long id);
	void deleteCustomer(long id);
	List<Customer> getCustomerByFirstName(String firstName);
	List<Customer> getCustomerByLastName(String lastName);
	List<Customer> getCustomerById(List<Long>id);
	List <Customer> getCustomerByFirstNameOrLastName(String firstName, String lastName);
	List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName);
	Customer getCustomerFullNameById(long id);
	List <Customer> getCustomerInDescOrder();
	 
	 
	 
	 
	 
	//List<Employee> getEmployeeByDepartment(long id);
	 
}
