package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Certificate {
	
	@Id
	private Integer id;
	private Integer year;
	
	//Default Constructor
	public Certificate() {
		super();
	}
     //parameterized Constructor
	public Certificate(Integer id, Integer year) {
		super();
		this.id = id;
		this.year = year;
	}
	
	//Getters And Setters Method
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Certificate [id=" + id + ", year=" + year + "]";
	}
	
	
	
	
	

}
