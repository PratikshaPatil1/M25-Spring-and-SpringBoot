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
public class CollegeController {
	
	@Autowired
	private CollegeService service;
	
	//RESTful API
	//creation
	@PostMapping("/college")
	public void add(@RequestBody College o)
	{
		service.create(o);
	}
	//deletion
	@DeleteMapping("/college/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	//Retrieve with all the records
	@GetMapping("/college")
	public List<College>list()
	{
		return service.listAll();
	}
	
	//Retrieve with specific id
	@GetMapping("/college/{id}")
	public  ResponseEntity<College> get(@PathVariable Integer id)
	{
		try {
			College o=service.retrieve(id);
			return new ResponseEntity<College>(o,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}
    //updation
	@PutMapping("/college/{id}")
	public ResponseEntity<College> update(@RequestBody College o, @PathVariable Integer id)
	{
		try {
			College o1=service.retrieve(id);
			service.create(o);
			return new ResponseEntity<College>(o,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}
}
