package com.neosoft.msproj.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.msproj.client.IUserServiceClient;
import com.neosoft.msproj.model.UserDetail;

@RestController
public class LoginController {
	
	@Autowired
	private IUserServiceClient client;
	
	@PostMapping("/validate")
	public ResponseEntity<String> validate(@RequestBody @Valid UserDetail userDetail) throws Exception{
		//calling to feign client
		return client.validateUser(userDetail.getUsn(), userDetail.getPwd());
	}
	@GetMapping("/getPort")
	public ResponseEntity<String> getPortNumber(){
		
		return new ResponseEntity<>("server.port of User service==>"+client.getPortNumber(),HttpStatus.OK);
	}

}
