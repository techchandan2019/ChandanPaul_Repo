package com.neosoft.msproj.controller;

import java.time.LocalDateTime;
import java.util.Random;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class ProductController {
	
	private static int count=0;
	

	@GetMapping("/getMessage")
	@HystrixCommand(defaultFallback ="dummyMethod",
					commandProperties = {
							@HystrixProperty(name="circuitBreaker.enabled",value = "true"),
							@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "5"),
							@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
										})
	public ResponseEntity<String> getMessage(){
		if(new Random().nextInt(10)<5)
			throw new RuntimeException("problem in getMessage method");
		return new ResponseEntity<>("Welcome "+LocalDateTime.now(),HttpStatus.OK);
	}
	public ResponseEntity<String> dummyMethod(){
		count++;
		return new ResponseEntity<>("Dummy method "+LocalDateTime.now()+", count: "+count,HttpStatus.OK);
	}
}
