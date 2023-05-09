package com.neosoft.msproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.msproj.model.UserInfo;
import com.neosoft.msproj.service.MyUserDetailsService;
import com.neosoft.msproj.utility.JWTUtils;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtils jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserInfo userRequest) throws Exception {

		//authenticate the username and password
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(userRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return new ResponseEntity<>(jwt,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody UserInfo user){
		return new ResponseEntity<>(userDetailsService.saveUser(user),HttpStatus.OK);
	}
	
	/*@GetMapping("/getUserDetails/{usn}")
	public ResponseEntity<UserDetails> getUserDetails(@PathVariable String usn){
		return new ResponseEntity<>(userDetailsService.loadUserByUsername(usn),HttpStatus.OK);
	}*/
	
}
