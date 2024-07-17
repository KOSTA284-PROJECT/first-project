package com.edu.vo;

public class User {
	
	private String id;
	private String password;
	private String name;
	private MyDate date;
	private String address; // 1.서울  2.인천  3.경기도

	//=============================
	private int point;
	private String email;
	private String phoneNumber;

	private String changeIntToString(int addressNum) {
		switch (addressNum) {
			case 1:
				return "서울";
			case 2:
				return "인천";
			case 3:
				return "경기도";
		}

		return "";
	}
	
	public User(String id, String password, String name, MyDate date, int addressNum) {
		String tmpAddress = changeIntToString(addressNum);
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
		this.address = tmpAddress;
	}

	public User(String id, String password, String name, MyDate date, int addressNum, int point, String email ,String phoneNumber) {
		String tmpAddress = changeIntToString(addressNum);
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
		this.point = point;
		this.email = email;
		this.address = tmpAddress;
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public MyDate getDate() {
		return date;
	}

	public int getPoint() {
		return point;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "[User] id: " + id + ", name: " + name + ", date: " + date + ", 보유 머니: " + point;
	}

}
