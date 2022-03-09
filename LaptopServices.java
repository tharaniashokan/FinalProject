package com.laptop.demolaptopLaptopServices;

import java.util.List;

import  com.laptop.demolaptopLaptop.Laptop; 

public interface LaptopServices {
	Laptop saveLaptop(Laptop laptop);
	 List <Laptop>getAllLaptop();
	 Laptop getLaptopById(long id);
	 Laptop updateLaptop (Laptop laptop , long id);
		void deleteLaptop(long id);
		List<Laptop> getLaptopByLaptopColor(String laptopcolor);//john
		List<Laptop> getLaptopByLaptopCompany(String laptopcompany);
		List< Laptop> getLaptopById(List<Long> id);
		List< Laptop> getLaptopByLaptopColorOrLaptopCompany(String laptopcolor, String laptopcompany);
		List< Laptop> getLaptopByLaptopColorAndLaptopCompany(String laptopcolor, String laptopcompany);
		//List<Employee> getEmployeeByDepartment(long id);
		 
		List< Laptop> getLaptopInDescOrder();
		List<Laptop> deletLaptop();
}
