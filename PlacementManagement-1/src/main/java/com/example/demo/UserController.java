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
public class UserController {
	
	@Autowired
	private UserService service;
	
	//RESTful API
	//creation
	@PostMapping("/user")
	public void add(@RequestBody User u)
	{
		service.create(u);
	}
	//deletion
	@DeleteMapping("/user/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	//Retrieve with all the records
	@GetMapping("/user")
	public List<User>list()
	{
		return service.listAll();
	}
	//Retrieve with specific id
	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id)
	{
		try {
			User u=service.retrieve(id);
			return new ResponseEntity<User>(u,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
		//updation
		@PutMapping("/user/{id}")
		public ResponseEntity<User> update(@RequestBody User u, @PathVariable Integer id)
		{
			try {
				User u1=service.retrieve(id);
				service.create(u);
				return new ResponseEntity<User>(u,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

}

