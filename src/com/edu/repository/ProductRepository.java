package com.edu.repository;


import com.edu.vo.Product;
import com.edu.vo.User;

public class ProductRepository{

//	private int sequence = 1;
//
//	////////////////////// 싱글톤으로 생성 //////////////////////
//	private static final Map<Integer, Product> products = new HashMap<>();
//
//
//	// ProductRepository 싱글톤으로 생성
//	private static final ProductRepository productRepository = new ProductRepository();
//
//	private ProductRepository() {}
//
//	public static ProductRepository getInstance() {
//		return productRepository;
//	}
//
//	//////////////////////////////////////////////////////////
//
//	//상품 구매하기
//	public void add(Product product) {
//		products.put(sequence++, product);
//		System.out.println(sequence-1 + "번 상품 등록 완료");
//	}
//
//	//전체 조회
//	public Map<Integer, Product> find() {
//	Map<Integer, Product> products;
//	public void setHashMap(Map<Integer, Product> products) {
//    	this.products = products;
//    }
//	public Map<Integer, Product> getHashMap() {
//		return products;
//	}
//
//	// 싱글톤
//	public static final ProductRepository service = new ProductRepository();
//	public ProductRepository() {
//		products = new HashMap<>();
//
//	//key에 해당하는 product 리턴
//	public Product find (int productKey) {
//		return products.get(productKey);
//	}
//	public static  ProductRepository getInstance() {
//		return service;
//	}
//	// 상품번호(key)
//	int i = 1;
//	public void add(Product product) {
//		// TODO
//		products.put(i++, product); // 상품번호, 상품
//
//	//해당 ID를 가진 유저가 등록한 상품들 리턴
//	public Map<Integer, Product> find (String id) {
//		Map<Integer, Product> map = new HashMap<>();
//		for (Integer key : products.keySet()) {
//			if (products.get(key).getUser().getId().equals(id))
//				map.put(key, products.get(key));
//		}
//		return map;
//	}
//	// 전체조회
//	public Map<Integer, Product> find () {
//		return products;
//
//	public void update(int productKey, Product updateProduct) {
//		products.replace(productKey, updateProduct);
//		System.out.println("\n[해당 상품("+productKey +")이 업데이트 되었습니다..]");
//	}
//
//	// delete
//
//	public void delete(int productKey) {
//		products.remove(productKey);
//		System.out.println("\n[해당 상품("+productKey +")이 삭제 되었습니다.]");
//	}
}
