package com.edu.service;

import com.edu.repository.UserRepository;
import com.edu.vo.MyDate;
import com.edu.vo.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * UserService 인터페이스의 구현 클래스입니다.
 * 유저 서비스 기능을 제공합니다.
 */
public class UserServiceImpl implements UserService {
	/**
	 * 
	 */
	private UserServiceImpl(){}

	/**
	 * 
	 * @return
	 */
	public static UserServiceImpl getInstance(){
		return userservice;
	}

	/**
	 * 
	 */
	private static UserServiceImpl userservice = new UserServiceImpl();
	/**
	 * 
	 */
	private UserRepository userRepository = UserRepository.getInstance();
	/**
	 * 포인트 충전용 전역변수
	 */
	public static final int CHARGE = 5000;
	/**
	 * 현재 로그인한 유저의 id를 저장합니다.
	 */
	String myId;

	/**
	 * user의 id값을 주입합니다.
	 * @param id
	 */
	public void setUser(String id) {
		this.myId = id;
	}

	/**
	 * 주소의 값을 문자열에서 숫자로 변환
	 * @param address 주소
	 * @return 주소를 숫자로 변환한 값
	 */
	public int addressStringToInt(String address) {
		switch (address) {
			case "서울":
				return 1;
			case "인천":
				return 2;
			case "경기도":
				return 3;
		}
		return 0;
	}

	/**
	 * 포인트를 충전하는 기능(첫 충전시, 5,000원 지급)
	 * @param id 아이디
	 * @param chargePoint 충전 포인트
	 */
	//포인트 충전
	@Override
	public void chargePoint(String id, int chargePoint) {
		User user = userRepository.find(id);
		String userId = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		MyDate date = user.getDate();
		String email = user.getEmail();
		int address = addressStringToInt(user.getAddress());
		int point = user.getPoint() + 5000; //첫 충전 5천원
		int point2 = point + chargePoint;
		int point3 = user.getPoint() + chargePoint;
		String phoneNumber = user.getPhoneNumber();
		boolean firstCharge = user.firstCharge();

		User updateUser = new User(userId, password, name, date, address, point, email, phoneNumber, firstCharge);
		User updateUser2 = new User(userId, password, name, date, address, point2, email, phoneNumber, true);
		User updateUser3 = new User(userId, password, name, date, address, point3, email, phoneNumber, true);

		if (user != null) {
			if(!user.firstCharge()) {
				userRepository.update(updateUser);// 첫 충전 시 5,000 포인트를 충전
				System.out.println("첫 충전 후 잔액: " + updateUser.getPoint());
				System.out.println(name + "님, 첫 충전 축하금 5,000원이 추가 충전 되었습니다.");
				userRepository.update(updateUser2);
			}else {
				userRepository.update(updateUser3);
			}
		} else {
			System.out.println("해당 ID의 사용자를 찾을 수 없습니다.");
		}
	}

	/**
	 * 다른 유저의 포인트를 변경하기 위한 메소드(상품 구매 시)
	 * @param user 구매하는 유저
	 * @param point 포인트
	 */
	public void chargePoint(User user, int point) {
		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		MyDate date = user.getDate();
		String email = user.getEmail();
		int address = addressStringToInt(user.getAddress());
		String phoneNumber = user.getPhoneNumber();
		boolean firstCharge = user.firstCharge();
		User updateUser = new User(id, password, name, date, address, point, email, phoneNumber, firstCharge);

		userRepository.update(updateUser);
	}

	/**
	 * 생일 축하 메세지 출력 및 포인트 5000원 추가하는 기능
	 * @param id 아이디
	 */
	@Override
	public void celebrateBirthday(String id) {
		LocalDate now = LocalDate.now();
		User user = userRepository.find(id);
		int nowDay = now.getMonthValue();
		if (nowDay == user.getDate().getMonth()){
			System.out.println("\n===============================================================");
			System.out.println("     ||||||||||||      안녕하세요. " + user.getName() + " 님!    ||||||||||||" );
			System.out.println("||||||||||||   " + user.getName() + "님의 생일을 진심으로 축하드립니다!!    ||||||||||||");
			System.out.println("===============================================================\n");

			String userId = user.getId();
			String password = user.getPassword();
			String name = user.getName();
			MyDate date = user.getDate();
			String email = user.getEmail();
			int address = addressStringToInt(user.getAddress());
			int point = user.getPoint() + CHARGE;
			String phoneNumber = user.getPhoneNumber();
			boolean firstCharge = user.firstCharge();
			System.out.println("생일 보너스를 받으셨습니다: " + CHARGE + ", 현재 포인트: " + point);

			User updateUser = new User(userId, password, name, date, address, point, email, phoneNumber, firstCharge);

			userRepository.update(updateUser);
		}
	}

	/**
	 * 같은 지역 이웃 찾기
	 */
	public void neighborFind() {
		User user = userRepository.find(myId);
		HashMap<String, User> userMap = userRepository.find(); //현재 회원가입 되어있는 모든 유저 반환

		String userAddress = user.getAddress();

		System.out.println("\n===== 나와 같은 지역에 거주하는 사람입니다. =====");
		for (String key : userMap.keySet()) {
			//현재 로그인한 유저와 동일한 주소를 갖는 유저를 찾는다.
			User tmpUser = userMap.get(key);
			if (userAddress.equals(tmpUser.getAddress())) {
				System.out.println("[" + key + "] 이름: " + tmpUser.getName() + ", 주소: " + tmpUser.getAddress() + ", 생일: " + tmpUser.getDate());
			}
		}
	}
}