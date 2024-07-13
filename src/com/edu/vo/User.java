package com.edu.vo;

public class User {
	
	private String id;
	private String password;
	private String name;
	private MyDate date;
	
	//=============================
	private int point;
	private String email;
	private String address;
	private String phoneNumber;
	
	public User(String id, String password, String name, MyDate date) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
	}

	public User(String id, String password, String name, MyDate date, int point, String email, String address,String phoneNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
		this.point = point;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "[User] id: " + id + ", name: " + name + ", date: " + date;
	}
	
	
	
	
	
	

}
