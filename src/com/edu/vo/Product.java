package com.edu.vo;

public abstract class Product {
	private String name;
	private int price;
	private String info;
	private String category;

	private  User user; // 유저 필요


	// [수정] User user -> 해당 상품을 어떤 유저가 등록했는지 확인하기 위한 정보를 저장...
	public Product(String name, int price, String info, String category, User user) {
		this.name = name;
		this.price = price;
		this.info = info;
		this.category = category;
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

	@Override
	public String toString() {
		return "[Product] name: " + name + ", price: " + price + ", info: " + info + ", category: " + category + "test 판매자확인 : " + user;
	}
	
	
	
	
}
