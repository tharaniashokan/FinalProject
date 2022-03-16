package com.laptop.demolaptopLaptopRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import  com.laptop.demolaptopLaptop.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{//CRUD

	List<Customer> findByFirstName(String firstName);//john

	List<Customer> findByLastName(String lastName);

	@Query("select e from Employee e where e.firstName = :name ")//JPQL
    List<Customer> findCustomerByFirstName(@Param("name") String firstName);//john

	//List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    @Query("select c from Customer c where c.firstName =:firstName and e.lastName= :lastName")
	List< Customer> findCustomerByFirstNameAndLastName(@Param("firstName")String firstName, @Param("lastName")String lastName);
	
	List<Customer> findByFirstNameOrLastName(String firstName, String lastName);
	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

	//@Query("select e from Employee where department_id= :id")
	//List<Employee> findByDepartmentId(@Param("id") Long id);
  
 
	
// CRUD
}
