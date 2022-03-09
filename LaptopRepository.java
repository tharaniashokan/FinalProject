package com.laptop.demolaptopLaptopRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import   com.laptop.demolaptopLaptop.Laptop;
public interface LaptopRepository extends JpaRepository<Laptop,Long>{
	List<Laptop> findByLaptopColor(String laptopcolor);//john

	List<Laptop> findByLaptopCompany(String laptopcompany);

	@Query("select e from Laptop l where l.laptopcolor = :color")//JPQL
    List<Laptop> findLaptopByLaptopColor(@Param("color") String laptopcolor);//john

	//List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    @Query("select e from Laptop l where l. laptopcompany =laptopcolor and l.laptopcompany= :laptopcompany")
	List<Laptop> findLaptopByLaptopColorAndLaptopCompany(@Param("laptopcolor")String laptopcolor, @Param("laptopcompany")String laptopcompany);
	
	List<Laptop> findByLaptopColorOrLaptopCompany(String laptopcolor, String laptopcompany);
	List<Laptop> findByLaptopColorAndLaptopCompany(String laptopcolor, String laptopcompany);

	//@Query("select e from Employee where department_id= :id")
	//List<Employee> findByDepartmentId(@Param("id") Long id);
@Query("select new com.laptop.demolaptopLaptop.Laptop (l.latopcolor, l.laptopcompany) from Laptop l where l.id = :id")
	Laptop findlaptopFullNameById(@Param("id") long id);

 @Query("select count(l.id)  from Laptop l ORDER BY l.laptopcolor desc")
 List<Laptop> findLaptopInDescOrder();
	//List<Employee> findEmployeesById(List<Long> idList);

 


}
