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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.msproj.model.Product;
import com.neosoft.msproj.service.IProductService;

@RestController
public class ProductController {
	
	private static Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private IProductService productService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody @Valid Product prod){
		logger.info("save product method of controller");
		String result=productService.registerProduct(prod);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
		
	}//close method
	
	@GetMapping("/get")
	public ResponseEntity<List<Product>> getAllProduct(){
		
		logger.info("get All product method of controller");
		return new ResponseEntity<>(productService.fetchAllProduct(),HttpStatus.OK);
	}
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<Product> getProductByProductId(@PathVariable Integer id) throws Exception{
		try {
			logger.info("get product by Id method");
			Product prod=productService.getProductById(id);
			return new ResponseEntity<>(prod,HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Problem in fetch by Id Method of controller");
			throw e;
		}
	}
	@PatchMapping("/updateById/{id}/{price}")
	public ResponseEntity<String> UpdateProductByProductId(@PathVariable Integer id,@PathVariable Double price) throws Exception{
		try {
			logger.info("update product price by Id method in controller");
			//partial update product by Id
			String result=productService.updateProductPrice(id, price);
			return new ResponseEntity<>(result,HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Problem in update product price by Id method in controller");
			throw e;
		}
	}
	@PutMapping("/update")
	public ResponseEntity<String> UpdateProduct(@RequestBody Product prod) throws Exception{
		try {
			logger.info("update product method in controller");
			//full update product
			String result=productService.updateProduct(prod);
			return new ResponseEntity<>(result,HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Problem in update product method in controller");
			throw e;
		}
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteProductByProductId(@PathVariable Integer id) throws Exception{
		try {
			logger.info("delete product method in controller");
			//partial update product by Id
			String result=productService.deleteProductById(id);
			return new ResponseEntity<>(result,HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Problem in delete product method in controller");
			throw e;
		}//catch
	}//method
	
}
