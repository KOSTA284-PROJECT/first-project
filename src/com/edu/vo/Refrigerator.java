package com.edu.vo;

public class Refrigerator extends Product {
	//capacity
	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public Refrigerator(String name, int price, String info, int category, int capacity, User user) {
		super(name, price, info, category, user);
		this.capacity = capacity;
	}
}
