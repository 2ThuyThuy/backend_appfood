package com.hithaui.exception;

public class ErrorMessage {
	
	private String message;
	private Integer status;
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(String message, Integer status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
