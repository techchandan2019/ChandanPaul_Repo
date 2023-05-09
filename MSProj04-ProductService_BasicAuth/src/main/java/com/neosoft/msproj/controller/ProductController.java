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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.msproj.model.Product;
import com.neosoft.msproj.service.IProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	private IProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody @Valid Product prod){
		String result=productService.registerProduct(prod);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}//close method
	
	@GetMapping("/get")
	public ResponseEntity<List<Product>> getAllProduct(){
		
		return new ResponseEntity<>(productService.fetchAllProduct(),HttpStatus.OK);
	}
	
	
	
}
