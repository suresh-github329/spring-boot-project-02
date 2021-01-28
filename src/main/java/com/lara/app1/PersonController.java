package com.lara.app1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public Person save(@RequestBody Person person) {
		personRepository.save(person);
		return person;
	}
	
	@RequestMapping(path = "/readAll", method = RequestMethod.GET)
	public List<Person> readAll(){
		List<Person> persons = (List<Person>) personRepository.findAll();
		return persons;
	}
	
	@RequestMapping(path = "/read/{id}", method = RequestMethod.GET)
	public Person read(@PathVariable Integer id) {
		Person person = personRepository.findById(id).get();
		return person;
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public Person delete(@PathVariable Integer id) {
		Person person = personRepository.findById(id).get();
		personRepository.deleteById(id);
		return person;
	}

}
