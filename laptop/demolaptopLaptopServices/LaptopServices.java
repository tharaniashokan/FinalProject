package com.laptop.demolaptopLaptopServices;

import java.util.List;

import  com.laptop.demolaptopLaptop.Laptop;

public interface LaptopServices {
	Laptop saveLaptop(Laptop laptop);
	 List <Laptop>getAllLaptop();
	 Laptop getLaptopById(long id);
	 Laptop updateLaptop (Laptop laptop , long id);
	 
	 
}
