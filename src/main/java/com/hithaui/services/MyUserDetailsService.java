package com.hithaui.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hithaui.models.Person;
import com.hithaui.repositories.PersonRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
			@Autowired
			private PersonRepository personRepository;
			

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
					Person person = personRepository.findByUsername(username);
					
				return new User(person.username,person.getPassword(), new HashSet<GrantedAuthority>());
			}
}
