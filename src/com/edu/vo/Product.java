package com.edu.vo;

import java.util.Scanner;

public abstract class Product {
	private String name;
	private int price;
	private String info;
	private String category;

	// [수정] User 정보를 담아 놓을 필드 추가
	private User user;

	// [수정] User user -> 해당 상품을 어떤 유저가 등록했는지 확인하기 위한 정보를 저장...
	public Product(String name, int price, String info, int category, User user) {
		String categoryName = "";
		switch (category) {
			case 1:
				categoryName = "노트북";
				break;
			case 2:
				categoryName = "냉장고";
				break;
			case 3:
				categoryName = "에어컨";
				break;
		}
		this.name = name;
		this.price = price;
		this.info = info;
		this.category = categoryName;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getInfo() {
		return info;
	}

	public String getCategory() {
		return category;
	}

	public User getUser() {
		return user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setCategory(int category) {
		String categoryName = "";
		switch (category) {
			case 1:
				categoryName = "노트북";
				break;
			case 2:
				categoryName = "냉장고";
				break;
			case 3:
				categoryName = "에어컨";
				break;
		}
		this.category = categoryName;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "[Product] 등록자 : " + user.getName() + ", 상품이름: " + name + ", price: " + price + ", info: " + info + ", category: " + category;
	}
	
}
