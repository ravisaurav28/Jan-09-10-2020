package com.synechron;

import java.lang.reflect.Method;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class Day02PeopleController {

	@Autowired
	private PersonDao personDao;
	

	@GetMapping("/people/{name}/{age}")
	public String savePerson(@PathVariable String name, @PathVariable @Min(1) @Max(120) int age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		personDao.save(person);
		return "Person with id: " + person.getId() + " created";
	}
	
	
	@GetMapping("/meta")
	public String getInfoAboutPersonDao() {
		StringBuilder sb = new StringBuilder("");
		sb.append("****************<br/>");

		sb.append("Class Name: ");
		sb.append(personDao.getClass().getName());
		
		sb.append("<br/>");
		sb.append("-----Interfaces the class implements<br/>");
		for (Class cls : personDao.getClass().getInterfaces()) {
			sb.append(cls.getName());
			sb.append("<br/>");
		}
		
		sb.append("<br/>");
		sb.append("-----Methods in the proxy class<br/>");
		for (Method method : personDao.getClass().getMethods()) {
			sb.append(method.getName());
			sb.append("<br/>");
		}
		
		sb.append("<br/>****************");
		return sb.toString();
	}
	
}









