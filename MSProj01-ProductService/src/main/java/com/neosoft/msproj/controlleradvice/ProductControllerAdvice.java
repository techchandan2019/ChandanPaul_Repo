package com.neosoft.msproj.controlleradvice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.neosoft.msproj.exception.ProductNotFoundException;
import com.neosoft.msproj.exception.ProductResException;

@RestControllerAdvice
public class ProductControllerAdvice {
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ProductResException handleProductException(ProductNotFoundException pnfe){
		ProductResException pre=new ProductResException(pnfe.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND);
		
		return pre;
		
	} 
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleProductException(MethodArgumentNotValidException ex){
		
		return new ResponseEntity<>(ex.getBindingResult().getAllErrors(),HttpStatus.BAD_REQUEST);
		
	} 
	
	@ExceptionHandler(value = Exception.class)
	public ProductResException handleException(Exception e){
		ProductResException pre=new ProductResException(e.getMessage(),LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		return pre;
		
	} 

}
