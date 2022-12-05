package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	
	//RESTful API
	//creation
	@PostMapping("/admin")
	public void add(@RequestBody Admin a)
	{
		service.create(a);
	}
	//deletion
	@DeleteMapping("/admin/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	//Retrieve with all the records
	@GetMapping("/admin")
	public List<Admin>list()
	{
		return service.listAll();
	}
	//Retrieve with specific id
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id)
	{
		try {
			Admin a=service.retrieve(id);
			return new ResponseEntity<Admin>(a,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		
	}
	@PutMapping("/admin/{id}")
	public ResponseEntity<Admin> update(@RequestBody Admin a, @PathVariable Integer id)
	{
		try {
			@SuppressWarnings("unused")
			Admin a1=service.retrieve(id);
			service.create(a);
			return new ResponseEntity<Admin>(a,HttpStatus.OK);
			
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	

}
