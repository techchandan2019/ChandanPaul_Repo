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
	
	@Value("${server.port}")
	private String port;
	@Autowired
	private IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveUser(@RequestBody @Valid UserInfo user)throws Exception{
		
		//calling service class method to save user
		String result=userService.registerUser(user);
		//returning the result to client side
		return new ResponseEntity<>(result,HttpStatus.CREATED);
		
	}//close method
	
	@GetMapping("/get")
	public ResponseEntity<List<UserInfo>> getAllUser(){
		//fetch and return all user details from service layer
	return new ResponseEntity<>(userService.fetchAllUser(),HttpStatus.OK);
	}
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<UserInfo> getUserByUserId(@PathVariable Integer id) throws Exception{
		try {
			//fetch user details from service layer by Id
			UserInfo unInfo=userService.getUserById(id);
			//returning User details
			return new ResponseEntity<>(unInfo,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@PatchMapping("/updatePassword/{unid}/{pwd}")
	public ResponseEntity<String> UpdateUserById(@PathVariable Integer unid,@PathVariable String pwd) throws Exception{
		try {
			//partial update User by Id
			String result=userService.updatePassword(unid, pwd);
			//returning updated result
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@DeleteMapping("/deleteUser/{unid}")
	public ResponseEntity<String> deleteUserByUserId(@PathVariable Integer unid) throws Exception{
		try {
			//partial update User by Id
			String result=userService.deleteUserById(unid);
			//returning updated result
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}//catch
	}//method
	
	@GetMapping("/validateUser/{usn}/{pwd}")
	public ResponseEntity<String> ValidateUser(@PathVariable String usn,@PathVariable String pwd) throws Exception{
		/*try {
			String result=userService.validateUserByUserDetails(usn, pwd);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}*/
		try {
			String result=userService.validateUserByUserDetails1(usn, pwd);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@GetMapping("/getPort")
	public ResponseEntity<String> getPortNumber(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("server.port==>"+port,HttpStatus.OK);
	}

}
