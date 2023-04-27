package com.neosoft.msproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.msproj.client.IUserServiceClient;
import com.neosoft.msproj.model.UserDetail;

@RestController
@RequestMapping("/LoginController")
public class LoginController {
	
	@Autowired
	private IUserServiceClient client;
	
	@PostMapping("/validate")
	public ResponseEntity<String> validate(@RequestBody UserDetail userDetail) throws Exception{
		//calling to feign client
		return client.ValidateUser(userDetail.getUsn(), userDetail.getPwd());
	}

}
