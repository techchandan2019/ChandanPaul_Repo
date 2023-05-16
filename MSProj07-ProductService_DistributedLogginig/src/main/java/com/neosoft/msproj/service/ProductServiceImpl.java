package com.neosoft.msproj.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.msproj.controller.ProductController;
import com.neosoft.msproj.exception.ProductNotFoundException;
import com.neosoft.msproj.model.Product;
import com.neosoft.msproj.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	private static Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private IProductRepository prodRepo;
	
	@Override
	public String registerProduct(Product prod) {
		logger.info("register product in service class");
		Product product=prodRepo.save(prod);
		
		return "product is saved with id :"+product.getProductId();
		
	}//close method
	@Override
	public List<Product> fetchAllProduct() {
		
		logger.info("Get all product in service class");
		//returning all product details
		return (List<Product>) prodRepo.findAll();
	}
	@Override
	public Product getProductById(Integer pid) throws ProductNotFoundException  {
		
		logger.info("Get product by Id method in service class");
		//fetch product by id
		 Optional<Product> opt=prodRepo.findById(pid);
		 if(opt.isPresent())
			 return opt.get();
		 else {
			 logger.error("problem in get product By id method of service class");
			 throw new ProductNotFoundException("product id not found");
		 }
	}//close 
	@Override
	public String updateProductPrice(Integer pid, Double price) throws ProductNotFoundException {
		
		logger.info("update product price by Id method in service class");
		//fetch product by id
		 Optional<Product> opt=prodRepo.findById(pid);
		 if(opt.isPresent()) {
			 
			 Product prod=opt.get();
			 //set the product name to the product Object
			prod.setProductPrice(price);;
			//save the product object(partial update) 
			prodRepo.save(prod);
			 return opt.get().getProductId()+" is updated successfully";
		 }//if
		 else {
			 logger.error("problem in update product price by Id method in service class");
			 throw new ProductNotFoundException("product id not found");
			 
		 }
	}//close method
	
	@Override
	public String updateProduct(Product prod) throws Exception {
		
		logger.info("update product method in service class");
		//fetch product by id
		 Optional<Product> opt=prodRepo.findById(prod.getProductId());
		 if(opt.isPresent()) {
			
			//update the product object
			prodRepo.save(prod);
			 return opt.get().getProductId()+" is updated successfully";
		 }//if
		 else {
			 logger.error("problem in update product method in service class");
			 throw new ProductNotFoundException("product id not found");
			 
		 }
	}
	@Override
	public String deleteProductById(Integer pid) throws ProductNotFoundException {
		
		logger.info("delete product by id method in service class");
		//fetch product by id
		 Optional<Product> opt=prodRepo.findById(pid);
		 if(opt.isPresent()) {
			 //delete the record using product id
			 prodRepo.deleteById(pid);
			 
			 return opt.get().getProductId()+" is deleted successfully";
		 }//if
		 else {
			 logger.error("problem in delete product by id method in service class");
			 throw new ProductNotFoundException("product id not found");
			 
		 }
	}//close

}
