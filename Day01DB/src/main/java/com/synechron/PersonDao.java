package com.synechron;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonDao extends JpaRepository<Person, Integer>{

	@Query("select p from com.synechron.Person p where p.age > :p1")
	List<Person> findPersonsWithAgeGreaterThan(@Param("p1") int age);
	
	
	//findBy
	Person findByName(String name);
	Person findByAge(int age);
	Person findByNameAndAge(String name, int age);
	Person findByIdAndName(int id, String name);
	Person findByNameAndId(String name, int id);
	Person findByIdAndAge(int id, int age);
	Person findByIdAndNameAndAge(int id, String name, int age);
	
	
	//findAllBy
	
	List<Person> findAllByName(String name);
	List<Person> findAllByAge(int age);
	List<Person> findAllByNameAndAge(String name, int age);
	List<Person> findAllByIdAndName(int id, String name);
	List<Person> findAllByNameAndId(String name, int id);
	List<Person> findAllByIdAndAge(int id, int age);
	List<Person> findAllByIdAndNameAndAge(int id, String name, int age);
	
}










