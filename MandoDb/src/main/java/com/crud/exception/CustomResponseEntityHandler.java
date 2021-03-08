package com.crud.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		
		String errordescrption=ex.getLocalizedMessage();
	
	ErrorMessage error=new ErrorMessage(new Date(),errordescrption,request.getDescription(false));
	
	return   new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	
	 
	}
	
}
