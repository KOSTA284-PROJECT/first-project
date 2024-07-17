package com.edu.service;

import com.edu.exception.NoBalanceException;
import java.util.ArrayList;
import com.edu.repository.ProductRepository;
import com.edu.vo.*;
/**
 * ProductService의 인터페이스입니다.
 * 상품 서비스의 기능을 제공합니다.
 */
public interface ProductService {

    /**
     * 상품 전체조회 기능     * 상품 전체조회 기능
     */
    void viewAllProduct();

    /**
     * 상품 텍스트 검색 기능
     * @param name 상품명
     */
	void findProductByName(String name);

    /**
     * 상품 상세조회 기능
     * @param productKey 상품번호
     */
    void viewProductDetail(int productKey);

    /**
     * 상품 구매하는 기능
     * @param productKey 상품번호
     * @throws NoBalanceException 구매 시 잔액이 없을 때 예외처리
     */
    void buyProduct(int productKey) throws NoBalanceException;

    /**
     * 내가 등록한 상품 조회 기능
     */
    void myProduct();

    /**
     * 상품의 카테고리 검색 기능
     * @param category 상품의 카테고리
     */
    void findProductByCategory(String category);

}
