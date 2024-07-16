package com.edu.impl;

import com.edu.repository.ProductRepository;
import com.edu.service.ProductService;
import com.edu.vo.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    // 싱글톤
    static ProductServiceImpl service = new ProductServiceImpl();
    public ProductServiceImpl() {}
    public static  ProductServiceImpl getInstance() {
        return service;
    }
    // ProductRepository 사용
    ProductRepository productRepo = ProductRepository.getInstance();

    //상품 전체 조회()
    public void viewAllProduct() {
        // TODO find, 가공
        Map<Integer, Product> temp = new HashMap<>();
        Map<Integer, Product> productsList = productRepo.find();
        for (Integer i : productsList.keySet()) {
            temp.put(i, productsList.get(i));
        }
        // 목록출력
        printProductList(temp);
    }

    //상품 텍스트 검색()
    public void findProductByName(String name) {
        // TODO
        Map<Integer, Product> temp = new HashMap<>();
        Map<Integer, Product> productsList = productRepo.find();
        // 검색한 상품에 대한 목록
        for (Integer i : productsList.keySet()) {
            if(productsList.get(i).getName().contains(name)) {
                temp.put(i, productsList.get(i));
            }
        }
        // 목록 출력
        printProductList(temp);
    }

    //상품 카테고리 검색()
    public void findProductByCategory(String category) {
        // TODO
        Map<Integer, Product> temp = new HashMap<>();
        Map<Integer, Product> productsList = productRepo.find();
        for (Integer i : productsList.keySet()) {
            if(productsList.get(i).getCategory().equals(category)){
                temp.put(i, productsList.get(i));
            }
        }
        // 목록 출력
        printProductList(temp);
    }

    // 목록츌력 공통 메소드
    private void printProductList(Map<Integer, Product> productList) {
        for (Integer i : productList.keySet()) {
            Product product = productList.get(i);
            System.out.println("["+i+"]"+ " 상품명: " + product.getName() + ", 가격: " + product.getPrice() + ", 상세정보: " + product.getInfo() + ", 카테고리: " + product.getCategory());
        }
    }

}
