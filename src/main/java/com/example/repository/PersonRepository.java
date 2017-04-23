package com.example.repository;

import org.springframework.data.repository.RepositoryDefinition;

import com.example.model.Person;

@RepositoryDefinition(domainClass = Person.class, idClass = Integer.class)
public interface PersonRepository {

	Person save(Person person);
	Iterable<Person> findAll();
}
