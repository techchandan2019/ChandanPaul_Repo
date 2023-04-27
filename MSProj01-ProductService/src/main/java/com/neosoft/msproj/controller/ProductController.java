package com.neosoft.msproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.msproj.model.Product;
import com.neosoft.msproj.service.IProductService;

@RestController
@RequestMapping("/productContoller")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestBody Product prod){
		//calling service class method to save product
		String result=productService.registerProduct(prod);
		//returning the result to client side
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}//close method
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct(){
		//fetch and return all product details from service layer
	return new ResponseEntity<>(productService.fetchAllProduct(),HttpStatus.OK);
	}
	@GetMapping("/fetchId/{id}")
	public ResponseEntity<Product> getProductByProductId(@PathVariable Integer id) throws Exception{
		try {
			//fetch product details from service layer by Id
			Product prod=productService.getProductById(id);
			//returning product details
			return new ResponseEntity<>(prod,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@PatchMapping("/updateName/{id}/{name}")
	public ResponseEntity<String> UpdateProductByProductId(@PathVariable Integer id,@PathVariable String name) throws Exception{
		try {
			//partial update product by Id
			String result=productService.updateProductName(id, name);
			//returning updated result
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@DeleteMapping("/deleteProd/{id}")
	public ResponseEntity<String> deleteProductByProductId(@PathVariable Integer id) throws Exception{
		try {
			//partial update product by Id
			String result=productService.deleteProductById(id);
			//returning updated result
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}//catch
	}//method
}
