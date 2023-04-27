package com.neosoft.msproj.service;

import java.util.List;

import com.neosoft.msproj.model.Product;

public interface IProductService {

	public String registerProduct(Product prod);
	public List<Product> fetchAllProduct();
	public Product getProductById(Integer pid)throws Exception;
	public String updateProductName(Integer pid,String prodName)throws Exception;
	public String deleteProductById(Integer pid)throws Exception;
}
