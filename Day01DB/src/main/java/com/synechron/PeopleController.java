package com.synechron;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PeopleController {

	@Autowired
	private PersonDao personDao;

	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/agegt/{age}")
	public List<Person> getPersonsWithAgeGt(@PathVariable int age) {
		return personDao.findPersonsWithAgeGreaterThan(age);
	}
	
	@GetMapping("/all")
	public List<Person> getAll() {
		return personDao.findAll();
	}
	
	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable int id) {
		Person person = personDao
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Person record not found"));
		personDao.delete(person);
		return "Person with id: " + id + " is deleted";
	}

	@PutMapping("/{id}/{age}")
	public Person updateAge(@PathVariable int id, @PathVariable int age) {
		Person person = personDao
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Person record not found"));
		person.setAge(age);
		personDao.save(person);
		return person;
	}


	@GetMapping("/{id}")
	public Person load(@PathVariable int id) {
		Person person = personDao
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Person record not found"));
		return person;
	}




	@PostMapping("/{name}/{age}")
	public String savePerson(@PathVariable String name, @PathVariable int age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		personDao.save(person);
		return "Person with id: " + person.getId() + " created";
	}

}














