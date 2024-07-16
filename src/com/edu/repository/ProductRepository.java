package com.edu.repository;

import java.util.HashMap;
import java.util.Map;

import com.edu.vo.Product;

public class ProductRepository{

	Map<Integer, Product> products;
	public void setHashMap(Map<Integer, Product> products) {
    	this.products = products;
    }
	public Map<Integer, Product> getHashMap() {
		return products;
	}

	// 싱글톤
	public static final ProductRepository service = new ProductRepository();
	public ProductRepository() {
		products = new HashMap<>();
	}
	public static  ProductRepository getInstance() {
		return service;
	}
	// 상품번호(key)
	int i = 1;
	public void add(Product product) {
		// TODO
		products.put(i++, product); // 상품번호, 상품
	}
	// 전체조회
	public Map<Integer, Product> find () {
		return products;
	}


}
