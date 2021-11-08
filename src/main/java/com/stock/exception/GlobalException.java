package com.stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleException(IdNotFoundException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}

	//#######################################################################################
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> handleException(UserAlreadyExistsException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	}	