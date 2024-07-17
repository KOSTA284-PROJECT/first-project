package com.edu.vo;
/**
 *유저의 생년월일을 정보를 저장합니다.
 */
public class MyDate {
	/**
	 *생년월일 중 연도
	 */
	private int year;
	/**
	 * 생년월일 중 월
	 */
	private int month;
	/**
	 * 생년월일 중 일
	 */
	private int day;

	/**
	 * 생성자 주입
	 * @param year 연도
	 * @param month 월
	 * @param day 일
	 */
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * 주입된 연도를 가져온다.
	 * @return 연도
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 주입된 월을 가져온다.
	 * @return 월
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * 주입된 일을 가져온다.
	 * @return 일
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 테스트 클래스에서 한번에 받고 형식이 맞지 않으면 예외처리를 하기 위해 필요한 메소드
	 * 지정된 형식으로 입력하면 "-"으로 나눈 후 parts 배열에 넣어 순서대로 필드에 주입해 객체 생성
	 * @param dateStr test클래스에서 주입 받은 값
	 * @return "-"으로 나눠 배열에 저장한 값을 주입해 객체를 생성
	 */
	//유저 등록할 때, 생년월일 입력할 때 형식 체크
	public static MyDate inputSc(String dateStr) {
		String[] parts = dateStr.split("-");

		if (parts.length != 3) {
			throw new IllegalArgumentException("형식을 확인하시고 다시 입력해주세요.");
		}

		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int day = Integer.parseInt(parts[2]);
		return new MyDate(year, month, day);
	}

	/**
	 * 객체의 문자열 표현을 반환합니다.
	 * 반환되는 문자열은 객체의 필드 값을 포함합니다:
	 * @return 객체의 문자열 표현
	 */
	@Override
	public String toString() {
		return year + "-" + month + "-" + day;
	}
}
