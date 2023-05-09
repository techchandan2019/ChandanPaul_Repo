package com.neosoft.msproj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.msproj.model.UserInfo;
import com.neosoft.msproj.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveUser(@RequestBody @Valid UserInfo user)throws Exception{
		
		String result=userService.registerUser(user);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<UserInfo>> getAllUser(){
		return new ResponseEntity<>(userService.fetchAllUser(),HttpStatus.OK);
	}

}
