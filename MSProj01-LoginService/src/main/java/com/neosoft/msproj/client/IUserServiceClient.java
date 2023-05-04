package com.neosoft.msproj.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("User-Service")
public interface IUserServiceClient {
	
	//it internally call user service controller validate method
	@GetMapping("/validateUser/{usn}/{pwd}")
	public ResponseEntity<String> validateUser(@PathVariable String usn,@PathVariable String pwd) throws Exception;
	
	@GetMapping("/getPort")
	public ResponseEntity<String> getPortNumber();
	
}
