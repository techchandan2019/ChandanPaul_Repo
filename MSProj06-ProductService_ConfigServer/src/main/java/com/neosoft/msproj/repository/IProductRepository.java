package com.neosoft.msproj.repository;

import org.springframework.data.repository.CrudRepository;

import com.neosoft.msproj.model.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {

}
