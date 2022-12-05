package com.example.demo;

	import java.util.List;

	import javax.transaction.Transactional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	@Service
	@Transactional
	public class PlacementService  {
		
		@Autowired
		private PlacementRepository repo;
		
		//To retrieve all the data for Placement Class
		public List<Placement> lisAll()
		{
			return repo.findAll();
		}
		
		//insert or create a data
		public void create(Placement p)
		{
			repo.save(p);
		}
		
		//To retrieve a single record
		public Placement retrieve(Integer id)
		{
			return repo.findById(id).get();
		}

		//To delete data from database
		public void delete(Integer id)
		{
			repo.deleteById(id);
		}

}
