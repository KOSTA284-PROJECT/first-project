package com.edu.vo;
/**
 * Product 중 AirConditioner 항목에 대한 정보를 저장합니다.
 * Product 클래스를 상속 받습니다.
 */
public class AirConditioner extends Product {
	/**
	 * Stand형 여부 필드선언
	 */
	private boolean stand;

	/**
	 * //////////////////////삭제합시다.
	 * @return
	 */
	public boolean isStand() {
		return stand;
	}

	public AirConditioner(String name, int price, String info, String category, User user) {
		super(name, price, info, category, user);
	}

	/**
	 * 생성자 주입
	 * @param name 상품명
	 * @param price 상품가격
	 * @param info 상품정보
	 * @param category 상품의 카테고리
	 * @param stand 스탠드형 여부
	 * @param user 상품을 등록한 유저
	 */
	public AirConditioner(String name, int price, String info, String category, boolean stand, User user) {
		super(name, price, info, category, user);
		this.stand = stand;
	} 
}
