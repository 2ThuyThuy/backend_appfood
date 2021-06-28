package com.hithaui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dto.PersonDTO;
import com.hithaui.exception.NotFoundException;
import com.hithaui.models.Person;
import com.hithaui.repositories.PersonRepository;


@RestController
@RequestMapping(value = "/api/person")
public class PersonController {
		
		@Autowired
		private PersonRepository personRepository;
		
		
		@GetMapping
		public ResponseEntity<?> getAllpeople(){
			 List<Person> people = personRepository.findAll();
			 return ResponseEntity.status(200).body(people);
		}
		
		
		@PostMapping
		public ResponseEntity<?> createNewPerson(@RequestBody PersonDTO personDTO) {
			
			Person person = new Person();
			
			person.setName(personDTO.getName());
			person.setSurname(personDTO.getSurname());
			person.setAge(personDTO.getAge());
			person.setUsername(personDTO.getUsername());
			person.setPassword(personDTO.getPassword());
			
			Person newPerson = personRepository.save(person);
			
			return ResponseEntity.status(201).body(newPerson);
		}
		
		@DeleteMapping("{personId}")
		public ResponseEntity<?> deletePersonById(@PathVariable("personId") Integer personId) throws Exception {
				Optional<Person> optionalPerson = personRepository.findById(personId);
				
				if(!optionalPerson.isPresent()) {
					throw new NotFoundException("Person ID not found");
				}
				Person person = optionalPerson.get();
				
				personRepository.deleteById(personId);
				
				return ResponseEntity.status(200).body(person);
		}
		@DeleteMapping("/delete")
		public ResponseEntity<?> deletePersonByUsername(@RequestParam("username") String username) throws Exception {
				Person person = personRepository.findByUsername(username);
				if(person  == null) {
					throw new NotFoundException("Person ID not found");
				}
				personRepository.deleteById(person.getId());
				
				return ResponseEntity.status(200).body(person);
		}
}
