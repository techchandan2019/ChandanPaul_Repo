package com.neosoft.msproj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ProductInfo")
public class Product {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName ="SQ1",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer productId;
	private String productName;
	private Double productPrice;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(Integer productId, String productName, Double productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	
	
	
	
	
	
	

}
