package com.hithaui.exception;

public class DuplicateException extends RuntimeException{

	private static final long serialVersionUID = 1L; 
	
	public DuplicateException(String messager) {
		super(messager);
	}
}
