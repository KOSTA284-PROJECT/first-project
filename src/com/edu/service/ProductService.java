package com.edu.service;
import java.util.ArrayList;
import com.edu.repository.ProductRepository;
import com.edu.vo.*;

public interface ProductService {
	// 상품 전체조회
	public void viewAllProduct();
	// 상품 텍스트 검색
	public void findProductByName(String name);
	// 상품 카테고리 검색
	public void findProductByCategory(String category);
}
