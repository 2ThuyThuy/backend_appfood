package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
			Person findByUsername(String username);
}
