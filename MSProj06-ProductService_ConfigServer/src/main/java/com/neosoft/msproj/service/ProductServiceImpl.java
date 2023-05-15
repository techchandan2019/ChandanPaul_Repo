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
//		if(prod.getProductName()!=null||prod.getProductPrice()!=null) {
		Product product=prodRepo.save(prod);
		
		return "product is saved with id :"+product.getProductId();
		/*}else {
			throw new RuntimeException("Product name and price should not be null");
		}*/
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
	public String updateProductPrice(Integer pid, Double price) throws ProductNotFoundException {
		
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
		 else
			 throw new ProductNotFoundException("product id not found");
	}//close method
	
	@Override
	public String updateProduct(Product prod) throws Exception {
		//fetch product by id
		 Optional<Product> opt=prodRepo.findById(prod.getProductId());
		 if(opt.isPresent()) {
			
			//update the product object
			prodRepo.save(prod);
			 return opt.get().getProductId()+" is updated successfully";
		 }//if
		 else
			 throw new ProductNotFoundException("product id not found");
	}
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
