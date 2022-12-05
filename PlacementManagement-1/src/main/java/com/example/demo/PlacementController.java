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
	public class PlacementController {
		
		@Autowired
		private PlacementService service;
		//creation
		@PostMapping("/Placement")
		public void add(@RequestBody Placement p)
		{
			service.create(p);
		}
		
		//deletion
		@DeleteMapping("/Placement/{id}")
		public void remove (@PathVariable Integer id)
		{
			service.delete(id);
		}
		
		//Retrieve data with all details
		@GetMapping("/Placement")
		public List<Placement>list()
		{
			return service.lisAll();
		}
		
		//Retrieve with specific ID
		@GetMapping("/Placement/{id}")
		public ResponseEntity<Placement>get(@PathVariable Integer id)
		{
			try 
			{
			Placement p=service.retrieve(id);
			return new ResponseEntity<Placement>(p,HttpStatus.OK);
			}
			
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
			}
		}
		
		//update any data
		@PutMapping("/Placement/{id}")
		public ResponseEntity<Placement>update(@RequestBody Placement p, @PathVariable Integer id)
		{
			try 
			{
			@SuppressWarnings("unused")
			Placement p1=service.retrieve(id);
			service.create(p);
			return new ResponseEntity<Placement>(p,HttpStatus.OK);
			}
			
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
			}
		}
		
	
		


}
