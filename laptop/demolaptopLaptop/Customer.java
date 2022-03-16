package com.laptop.demolaptopLaptop;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;


@Data
@Entity
@Table(name="customerTbl")
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	@Transient
	private int count;
	
	
	 
	 
	public Customer() {
		
	}

	public  Customer(String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public  Customer(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	 
	
	
	
	
}
