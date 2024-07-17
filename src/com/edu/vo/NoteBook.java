package com.edu.vo;
/**
 * Product 중 NoteBook 항목에 대한 정보를 저장합니다.
 * Product 클래스를 상속 받습니다.
 */
public class NoteBook extends Product {
	/**
	 * 제조사 필드선언
	 * */
	private String company;

	public NoteBook(String name, int price, String info, String category, User user) {
			super(name, price, info, category, user);
	}

	/**
	 * 생성자 주입
	 * @param name 상품명
	 * @param price 가격
	 * @param info 상품정보
	 * @param category 상품의 카테고리
	 * @param company 제조사
	 * @param user 상품을 등록한 유저
	 */
	public NoteBook(String name, int price, String info, String category, String company, User user) {
		super(name, price, info, category, user);
		this.company = company;
	}

	/**
	 * 주입된 제조사를 가져온다.
	 * @return 제조사
	 */
	public String getCompany() {
		return company;
	}

}
