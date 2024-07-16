package com.edu.service;

import com.edu.exception.NoBalanceException;

public interface ProductService {

    //테스트용 메소드...
    String userInfo();

    //상품 전체 조회()
    void viewAllProduct();

    //상품 상세 조회() -> 나
    void viewProductDetail(int productKey);

    //상품 구매
    void buyProduct(int productKey) throws NoBalanceException;

    //내가 등록한 상품 조회()
    void myProduct();

    //상품 텍스트 검색()
    void findProductByName(String name);

    //상품 카테고리 검색()
    void findProductByCategory(int category);

}
