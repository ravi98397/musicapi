package com.api.music.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleCustomIdNotFoundException(IdNotFoundException exception){
		return new ResponseEntity<>("Custome Exception" + exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(IdNotFoundException exception){
		return new ResponseEntity<>("Custome Exception" + exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
