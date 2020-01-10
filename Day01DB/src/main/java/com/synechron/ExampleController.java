package com.synechron;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@Validated
public class ExampleController {
	@Autowired
	private PersonDao personDao;
	
	@GetMapping("/add/{a}/{b}")
	public String add(@PathVariable @Min(1) int a, @PathVariable @Min(1) int b) {
		return "Sum : " + (a + b);
	}
	
	@GetMapping("/{id}")
	public Person load(@PathVariable int id) {
		Person person = personDao
				.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Id: " + id));
		return person;
	}
	

	
	
	
	
	
}









