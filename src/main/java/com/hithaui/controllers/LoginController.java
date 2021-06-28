package com.hithaui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dto.AuthenticationResponse;
import com.hithaui.dto.LoginDTO;
import com.hithaui.models.Person;
import com.hithaui.repositories.PersonRepository;
import com.hithaui.services.MyUserDetailsService;
import com.hithaui.utils.JwtUtil;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
		@Autowired
		private JwtUtil jwtUtil;
		
		@Autowired
		private MyUserDetailsService myUserDetailsService;
		
		@Autowired
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private PersonRepository personRepository;
		
		@PostMapping
		public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) throws Exception {
			
			try {
					authenticationManager.authenticate(
							new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));
			} catch (BadCredentialsException e) {
				// TODO: handle exception
				throw new Exception("Incorrect username or password");
			}
			final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginDTO.getUsername());
			final String jwt = jwtUtil.generateToken(userDetails);
			Person person = personRepository.findByUsername(loginDTO.getUsername());
			return ResponseEntity.status(200).body(new AuthenticationResponse(jwt,person.getId(),person.getUsername()));
		}
		
}
