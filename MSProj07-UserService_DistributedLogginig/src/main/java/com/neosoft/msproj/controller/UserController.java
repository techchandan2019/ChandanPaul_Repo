package com.neosoft.msproj.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private static Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveUser(@RequestBody @Valid UserInfo user)throws Exception{
		logger.info("save user method of user controller class");
		String result=userService.registerUser(user);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
		
	}//close method
	
	@GetMapping("/get")
	public ResponseEntity<List<UserInfo>> getAllUser(){
		logger.info("get all user method of user controller class");
		return new ResponseEntity<>(userService.fetchAllUser(),HttpStatus.OK);
	}
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<UserInfo> getUserByUserId(@PathVariable Integer id) throws Exception{
		try {
			logger.info("fetch user by Id method of user controller class");
			UserInfo unInfo=userService.getUserById(id);
			return new ResponseEntity<>(unInfo,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("problem in fetch user by Id method of user controller class");
			throw e;
		}
	}
	@PatchMapping("/updatePassword/{unid}/{pwd}")
	public ResponseEntity<String> UpdateUserById(@PathVariable Integer unid,@PathVariable String pwd) throws Exception{
		try {
			logger.info("update password of user method of user controller class");
			String result=userService.updatePassword(unid, pwd);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e) {
			logger.error("problem in update password of user method of user controller class");
			e.printStackTrace();
			throw e;
		}
	}
	@DeleteMapping("/deleteUser/{unid}")
	public ResponseEntity<String> deleteUserByUserId(@PathVariable Integer unid) throws Exception{
		try {
			logger.info("delete user method of user controller class");
			String result=userService.deleteUserById(unid);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e) {
			logger.error("problem in delete user method of user controller class");
			e.printStackTrace();
			throw e;
		}//catch
	}//method
	
	@GetMapping("/validateUser/{usn}/{pwd}")
	public ResponseEntity<String> ValidateUser(@PathVariable String usn,@PathVariable String pwd) throws Exception{
		
		try {
			logger.info("validate user method of user controller class");
			String result=userService.validateUserByUserDetails1(usn, pwd);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e) {
			logger.error("problem in validate user method of user controller class");
			e.printStackTrace();
			throw e;
		}
	}

}
