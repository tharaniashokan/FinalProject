package com.laptop.demolaptopLaptopServicelmpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import   com.laptop.demolaptopLaptop.Laptop;
import    com.laptop.demolaptopResourceNotFound.Exception.ResourceNotFoundException;
import   com.laptop.demolaptopLaptopRepository.LaptopRepository;
import  com.laptop.demolaptopLaptopServices.LaptopServices;


@Service
public class LaptopServiceImpl implements LaptopServices
{

	private  LaptopRepository laptopRepository;
	
	
	public LaptopServiceImpl(LaptopRepository laptopRepository) {
		super();
		this. laptopRepository = laptopRepository;
	}


	@Override
	public Laptop saveLaptop( Laptop  laptop) {
		return laptopRepository.save(laptop);
	}


	@Override
	public List< Laptop> getAllLaptop() {
		return laptopRepository.findAll();
		
	}


	@Override
	public  Laptop getLaptopById(long id) {
		Optional< Laptop>  laptop = laptopRepository.findById(id);
		if(laptop.isPresent()) {
			return laptop.get();
		}
		else {
          
			throw new ResourceNotFoundException(" Laptop","Id",id);
		}
		
	}


	@Override
	public Laptop updateLaptop( Laptop laptop, long id) {
		Laptop lap = new Laptop();
		 
	 try {
		   lap = laptopRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFoundException(" Laptop","Id",id));
	} catch (ResourceNotFoundException e) {
		
		e.printStackTrace();
	}
	 lap.setLaptopname(laptop.getLaptopname());
	 lap.setLaptopprice(laptop.getLaptopprice());
	 lap.setLaptopcompany(laptop.getLaptopcompany());
	 lap.setLaptopcolor(laptop.getLaptopcolor());
	 
	 
	  
	 
	 laptopRepository.save(lap);
	return lap;
	}


	

}
