package com.edu.vo;

public class Refrigerator extends Product {
	//capacity
	private int capacity;

	public Refrigerator(String name, int price, String info, String category, int capacity, User user) {
		super(name, price, info, category, user);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
}
