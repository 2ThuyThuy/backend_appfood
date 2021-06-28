package com.hithaui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
		
		@ExceptionHandler(NotFoundException.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public ErrorMessage  notfound (NotFoundException ex, WebRequest request) {
			return new ErrorMessage(ex.getMessage(), 404);
		}
		
		@ExceptionHandler(DuplicateException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public ErrorMessage duplicatErrorMessage(DuplicateException ex, WebRequest request) {
			return new ErrorMessage(ex.getMessage(), 403);
		}
}
