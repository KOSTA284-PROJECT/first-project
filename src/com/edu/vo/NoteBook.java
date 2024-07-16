
package com.edu.vo;

public class NoteBook extends Product {
	//제조사
	private String company;

	public NoteBook(String name, int price, String info, int category, String company, User user) {
		super(name, price, info, category, user);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}
}
