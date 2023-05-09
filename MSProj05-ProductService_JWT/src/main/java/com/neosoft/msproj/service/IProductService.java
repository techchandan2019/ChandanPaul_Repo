package com.neosoft.msproj.service;

import java.util.List;

import com.neosoft.msproj.model.Product;

public interface IProductService {

	public String registerProduct(Product prod);
	public List<Product> fetchAllProduct();
	public Product getProductById(Integer pid)throws Exception;
	public String updateProductPrice(Integer pid,Double price)throws Exception;
	public String updateProduct(Product prod)throws Exception;
	public String deleteProductById(Integer pid)throws Exception;
}
