package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	//to retrieve all the data of User class
	public List<User>listAll()
	{
		return repo.findAll();
	}
	//insert/create/update a data
	public void create(User u)
	{
		repo.save(u);
	}
	//to retrieve a single record
	public User retrieve(Integer id)
	{
		return repo.findById(id).get();
	}
	//to delete a data
	public void delete(Integer id)
	{
		repo.deleteById(id);
	}
	
	
	

}
