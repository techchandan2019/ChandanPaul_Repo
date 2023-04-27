package com.neosoft.msproj.controlleradvice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.neosoft.msproj.exception.ErrorMessage;
import com.neosoft.msproj.exception.UserDetailsNotFoundException;

@RestControllerAdvice
public class UserControllerAdvice {
	
	@ExceptionHandler(value = UserDetailsNotFoundException.class)
	public ErrorMessage handleProductException(UserDetailsNotFoundException pnfe){
		//create custom object ErrorMessage class
		ErrorMessage errorMessage=new ErrorMessage(pnfe.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND);
		
		return errorMessage;
		
	} 
	@ExceptionHandler(value = Exception.class)
	public ErrorMessage handleException(Exception e){
		//create custom object ErrorMessage class
		ErrorMessage errorMessage=new ErrorMessage(e.getMessage(),LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		return errorMessage;
		
	} 

}
