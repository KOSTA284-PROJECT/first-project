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

	private Boolean firstCharge = false;

	public User(String id, String password, String name, MyDate date, int addressNum) {
		String tmpAddress = "";
		switch (addressNum) {
			case 1:
				tmpAddress = "서울";
				break;
			case 2:
				tmpAddress = "인천";
				break;
			case 3:
				tmpAddress = "경기도";
				break;
		}
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
		this.address = tmpAddress;
	}

	public User(String id, String password, String name, MyDate date, int addressNum, int point, String email ,String phoneNumber) {
		String tmpAddress = "";
		switch (addressNum) {
			case 1:
				tmpAddress = "서울";
				break;
			case 2:
				tmpAddress = "인천";
				break;
			case 3:
				tmpAddress = "경기도";
				break;
		}
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
		this.point = point;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.firstCharge = false;
	}

	@Override
	public String toString() {
		return "[User] id: " + id + ", name: " + name + ", date: " + date + " point :"+point + " email" + email + " address"+address + " phoneNumber" + phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getDate() {
		return date;
	}

	public void setDate(MyDate date) {
		this.date = date;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean firstCharge() {
		return firstCharge;
	}

	public void setfirstCharge(boolean isFirstCharge) {
		this.firstCharge = isFirstCharge;
	}

	public void chargePoint(int amount) {
		this.point += amount;
	}
}
