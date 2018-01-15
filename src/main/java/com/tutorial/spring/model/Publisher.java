package com.tutorial.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * A class that represents an publisher.
 * 
 * @author Bastian Bräunel
 */
 @Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	
	/**
	 * default constructor
	 */
	public Publisher() {
		this.name = "unkown";
		this.address = "unkown adress";
	}
	
	/**
	 * constructor to create a publisher object 
	 * 
	 * @param name		the name of the publisher
	 * @param adress	the address of the publishers hq
	 */
	public Publisher(String name, String address) {
		this.name = name;
		this.address = address;
	}

		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
