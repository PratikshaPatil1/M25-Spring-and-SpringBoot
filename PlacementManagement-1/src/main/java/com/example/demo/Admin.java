package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	private Integer id;
	private String name;
	private String password;
	
	//Default Constructor
	public Admin() {
		super();
	}

	//parameterized constructor
	public Admin(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	//Getters And Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	

	

}
