package com.hithaui.dto;

public class AuthenticationResponse {
	private String jwt;

	private Integer personId;
	
	private String username;

	
	
	public AuthenticationResponse() {
		super();
	}
	
	
	
	public AuthenticationResponse(String jwt, Integer personId, String username) {
		super();
		this.jwt = jwt;
		this.personId = personId;
		this.username = username;
	}



	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
