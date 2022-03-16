package com.laptop.demolaptopLaptop;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="laptop_details")
public class Laptop {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="laptop_name")
	private String laptopname;
	@Column(name="laptop_price")
    private Float laptopprice;
	@Column(name="laptop_company")
	private String laptopcompany;
	@Column(name="laptop_color")
	private String laptopcolor;
	 
	
	

}

