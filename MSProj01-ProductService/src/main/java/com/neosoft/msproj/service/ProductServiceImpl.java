package com.neosoft.msproj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.msproj.exception.ProductNotFoundException;
import com.neosoft.msproj.model.Product;
import com.neosoft.msproj.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository prodRepo;
	
	@Override
	public String registerProduct(Product prod) {
		
		//calling CRUD repository class save method 
		Product product=prodRepo.save(prod);
		//returning  result to controller layer
		return "product is saved with id :"+product.getProductId();
	}//close method
	@Override
	public List<Product> fetchAllProduct() {
		//returning all product details
		return (List<Product>) prodRepo.findAll();
	}
	@Override
	public Product getProductById(Integer pid) throws ProductNotFoundException  {
		//fetch product by id
		 Optional<Product> opt=prodRepo.findById(pid);
		 if(opt.isPresent())
			 return opt.get();
		 else
			 throw new ProductNotFoundException("product id not found");
	}//close 
	@Override
	public String updateProductName(Integer pid, String prodName) throws ProductNotFoundException {
		
		//fetch product by id
		 Optional<Product> opt=prodRepo.findById(pid);
		 if(opt.isPresent()) {
			 
			 Product prod=opt.get();
			 //set the product name to the product Object
			prod.setProductName(prodName);
			//save the product object(partial update) 
			prodRepo.save(prod);
			 return opt.get().getProductId()+" is updated successfully";
		 }//if
		 else
			 throw new ProductNotFoundException("product id not found");
	}//close method
	@Override
	public String deleteProductById(Integer pid) throws ProductNotFoundException {
		//fetch product by id
		 Optional<Product> opt=prodRepo.findById(pid);
		 if(opt.isPresent()) {
			 //delete the record using product id
			 prodRepo.deleteById(pid);
			 
			 return opt.get().getProductId()+" is deleted successfully";
		 }//if
		 else
			 throw new ProductNotFoundException("product id not found");
	}//close

}
