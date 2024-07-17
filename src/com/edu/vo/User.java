package com.edu.vo;
/**
 * 가입한 유저의 정보를 저장합니다.
 */
public class User {
	/**
	 * 유저 생성에 필요한 필드 선언
	 */
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

	/**
	 * 숫자로 받은 값을 문자열로 변환하는 기능
	 * @param addressNum 주소 선택 옵션
	 * @return 문자열로 변환된 주소
	 */
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

	/**
	 * 생성자 주입
	 * @param id 아이디
	 * @param password 패스워드
	 * @param name 이름
	 * @param date 생년월일
	 * @param addressNum 주소
	 */
	public User(String id, String password, String name, MyDate date, int addressNum) {
		String tmpAddress = changeIntToString(addressNum);
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
		this.address = tmpAddress;
	}

	/**
	 * 생성자 주입
	 * @param id 아이디
	 * @param password 패스워드
	 * @param name 이름
	 * @param date 생년월일
	 * @param addressNum 주소
	 * @param point 포인트
	 * @param email 이메일
	 * @param phoneNumber 휴대폰 번호
	 * @param firstCharge 첫 충전 여부확인
	 */
	public User(String id, String password, String name, MyDate date, int addressNum, int point, String email ,String phoneNumber, boolean firstCharge) {
		String tmpAddress = changeIntToString(addressNum);
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
		this.point = point;
		this.email = email;
		this.address = tmpAddress;
		this.phoneNumber = phoneNumber;
		this.firstCharge = firstCharge;
	}

	/**
	 * 주입된 값을 반환합니다.
	 * @return 아이디
	 */
	public String getId() {
		return id;
	}

	/**
	 * 주입된 값을 반환합니다.
	 * @return 패스워드
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 주입된 값을 반환합니다.
	 * @return 이름
	 */
	public String getName() {
		return name;
	}

	/**
	 * 주입된 값을 반환합니다.
	 * @return 생년월일
	 */
	public MyDate getDate() {
		return date;
	}

	/**
	 * 주입된 값을 반환합니다.
	 * @return 포인트
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * 주입된 값을 반환합니다.
	 * @return 이메일
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 주입된 값을 반환합니다.
	 * @return 주소
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 주입된 값을 반환합니다.
	 * @return 휴대폰 번호
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 값을 주입합니다.
	 * @param password 패스워드
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 값을 주입합니다.
 	 * @param point 포인트
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * 값을 반환합니다.
	 * @return 첫충전
	 */
	public boolean firstCharge() {
		return firstCharge;
	}
	/**
	 * 값을 주입합니다.
	 * @param isFirstCharge 첫충전 여부
	 */
	public void setfirstCharge(boolean isFirstCharge) {
		this.firstCharge = isFirstCharge;
	}

	/**
	 * 충전 포인트를 더하는 기능
	 * @param amount 충전액
	 */
	public void chargePoint(int amount) {
		this.point += amount;
	}


	/**
	 * 객체의 문자열 표현을 반환합니다.
	 * 반환되는 문자열은 객체의 필드 값을 포함합니다:
	 * @return 객체의 문자열 표현
	 */
	@Override
	public String toString() {
		return "[User] id: " + id + ", name: " + name + ", date: " + date + ", 보유 머니: " + point;
	}

}
