package com.edu.vo;

public abstract class Product {
	private String name;
	private int price;
	private String info;
	private String category;

	private  User user; // 유저 필요
	
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

	public void setPrice(int price) {
		this.price = price;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "[Product] name: " + name + ", price: " + price + ", info: " + info + ", category: " + category + "test 판매자확인 : " + user;
	}
	
	
	
	
}
