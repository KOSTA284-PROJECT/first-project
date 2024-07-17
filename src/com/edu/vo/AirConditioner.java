package com.edu.vo;

public class AirConditioner extends Product {
	
	private boolean stand;

	public boolean isStand() {
		return stand;
	}

	public AirConditioner(String name, int price, String info, String category, boolean stand, User user) {
		super(name, price, info, category, user);
		this.stand = stand;
	} 
}
