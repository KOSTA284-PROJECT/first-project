package com.edu.repository;

import java.util.HashMap;
import java.util.Map;

import com.edu.vo.Product;
/**
 * 
 */
public class ProductRepository{
	/**
	 * 상품의 번호
	 */
	private int sequence = 1;
	/**
	 * ProductServiceImpl 클래스의 유일한 인스턴스를 생성합니다.
	 */
	private static final Map<Integer, Product> products = new HashMap<>();
	/**
	 * ProductServiceImpl 클래스의 유일한 인스턴스를 생성합니다.
	 */
	private static final ProductRepository productRepository = new ProductRepository();
	/**
	 * ProductRepository의 기본 생성자.
	 * <p>
	 * 생성자를 private으로 지정하여 외부에서 새로운 인스턴스를 생성하지 못하도록 합니다.
	 * </p>
	 */
	private ProductRepository() {}

	/**
	 * ProductRepository의 유일한 인스턴스를 반환합니다.
	 * <p>
	 * 이 메서드는 싱글톤 패턴을 구현하며, 항상 동일한 인스턴스를 반환합니다.
	 * </p>
	 *
	 * @return ProductRepository의 유일한 인스턴스
	 */
	public static ProductRepository getInstance() {
		return productRepository;
	}

	/**
	 * 상품 등록 시 ProductRepository에 저장
	 * @param product 등록된 상품
	 */
	public void add(Product product) {
		products.put(sequence++, product);
		System.out.println(sequence-1 + "번 상품 등록 완료");
	}

	/**
	 * ProductRepository에 저장된 전체 상품 리스트를 반환
	 * @return 전체 상품 리스트
	 */
	public Map<Integer, Product> find() {
		return products;
	}

	/**
	 * ProductRepository에 저장된 상품 중 상품번호에 해당하는 product 정보를 반환
	 * @param productKey 상품 번호
	 * @return 해당 상품 정보 반환
	 */
	public Product find (int productKey) {
		return products.get(productKey);
	}

	/**
	 * 유저가 자신이 등록한 상품 목록 조회
	 * @param id 로그인한 유저 아이디
	 * @return 로그인한 유저가 등록한 상품리스트
	 */
	public Map<Integer, Product> find (String id) {
		Map<Integer, Product> map = new HashMap<>();

		for (Integer key : products.keySet())
			if (products.get(key).getUser().getId().equals(id))
				map.put(key, products.get(key));
		return map;
	}

	/**
	 * 상품의 정보를 수정합니다.
	 * @param productKey 상품번호
	 * @param updateProduct 수정한 상품 정보
	 */
	public void update(int productKey, Product updateProduct) {
		products.replace(productKey, updateProduct);
		System.out.println("\n[해당 상품("+productKey +")이 업데이트 되었습니다..]");
	}

	/**
	 * 상품을 번호를 전달받아 해당하는 상품을 삭제합니다.
	 * @param productKey 상품번호ㄹ
	 */
	public void delete(int productKey) {
		products.remove(productKey);
		System.out.println("\n[해당 상품("+productKey +")이 삭제 되었습니다.]");
	}
}
