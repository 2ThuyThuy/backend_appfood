package com.hithaui.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;


@Entity
@Table(name = "Person")
public class Person {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Integer id;
			
		@Nationalized
		@Column(name = "name",nullable = false)
		public String name;
		
		@Nationalized
		@Column(name = "sur_name",nullable = false)
		public String surname;
		
		@Column(name = "age",nullable = false)
		public Integer age;
		
		@Column(name = "user_name",nullable = false, unique = true)
		public String username;
		
		@Column(name = "password", nullable = false)
		public String password;

		public Person() {
			super();
		}
		

		public Person(Integer id, String name, String surname, Integer age, String username, String password) {
			super();
			this.id = id;
			this.name = name;
			this.surname = surname;
			this.age = age;
			this.username = username;
			this.password = password;
		}


		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	
		public String getSurname() {
			return surname;
		}


		public void setSurname(String surname) {
			this.surname = surname;
		}


		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		
		
		
}
