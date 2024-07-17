package com.edu.vo;
/**
 * 상품의 정보를 저장하는 추상 클래스
 */
public abstract class Product {
	/**
	 * 상품명
	 */
	private String name;
	/**
	 * 상품가격
	 */
	private int price;
	/**
	 * 상품정보
	 */
	private String info;
	/**
	 * 상품의 카테고리
	 */
	private String category;
	/**
	 * 상품을 등록한 유저
	 */
	private  User user; // 유저 필요


	// [수정] User user -> 해당 상품을 어떤 유저가 등록했는지 확인하기 위한 정보를 저장...

	/**
	 * 생성자 주입
	 * @param name 상품명
	 * @param price 상품가격
	 * @param info 상품정보
	 * @param category 상품의 카테고리
	 * @param user 상품을 등록한 유저
	 */
	public Product(String name, int price, String info, String category, User user) {
		this.name = name;
		this.price = price;
		this.info = info;
		this.category = category;
		this.user = user;
	}

	/**
	 * 주입된 상품명을 가져온다.
	 * @return 상품명
	 */
	public String getName() {
		return name;
	}

	/**
	 * 주입된 상품가격을 가져온다.
	 * @return 상품가격
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 주입된 상품정보를 가져온다.
	 * @return 상품정보
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * 주입된 상품의 카테고리를 가져온다.
	 * @return 상품의 카테고리
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 주입된 상품을 등록한 유저를 가져온다.
	 * @return 상품을 등록한 유저
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 객체의 문자열 표현을 반환합니다.
	 * 반환되는 문자열은 객체의 필드 값을 포함합니다:
	 * @return 객체의 문자열 표현
	 */
	@Override
	public String toString() {
		return "[Product] name: " + name + ", price: " + price + ", info: " + info + ", category: " + category + "test 판매자확인 : " + user;
	}
	
	
	
	
}
