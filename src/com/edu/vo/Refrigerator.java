/**
 * Product 중 Refrigerator 항목에 대한 정보를 저장합니다.
 */
package com.edu.vo;
/**
 *Product 클래스를 상속 받습니다.
 */
public class Refrigerator extends Product {
	/**
	 * 냉장고 용량 필드선언
	 */

	private int capacity;

	public Refrigerator(String name, int price, String info, String category, User user) {
		super(name, price, info, category, user);
	}

	/**
	 * 생성자 주입
	 * @param name 상품명
	 * @param price 상품가격
	 * @param info 상품정보
	 * @param category 상품의 카테고리
	 * @param capacity 냉장고 용량
	 * @param user 상품을 등록한 유저
	 */
	public Refrigerator(String name, int price, String info, String category, int capacity, User user) {
		super(name, price, info, category, user);
		this.capacity = capacity;
	}

	/**
	 * 주입된 용량을 가져옵니다.
	 * @return 용량
	 */
	public int getCapacity() {
		return capacity;
	}
}
