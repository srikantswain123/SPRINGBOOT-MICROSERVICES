package com.nt.ErrorController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.ErrorController.model.ErrorType;
import com.nt.exception.EmployeeException;
@RestControllerAdvice
public class MyErrorController {
	
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorType> EmpNotFoundException(EmployeeException ex){
		
		return new ResponseEntity<ErrorType>(new ErrorType(ex.getMessage(), "EMployee Not found", "EMployye"), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> methodNotFound(HttpRequestMethodNotSupportedException ex){
		
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
	}

}
