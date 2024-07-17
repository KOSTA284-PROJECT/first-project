package com.edu.service;

import com.edu.repository.UserRepository;
import com.edu.vo.MyDate;
import com.edu.vo.User;

import java.time.LocalDate;
import java.util.HashMap;

public class UserServiceImpl implements UserService {

	// 싱글톤,,,
	private static final UserRepository userRepository = UserRepository.getInstance();
	private static final UserServiceImpl userService = new UserServiceImpl();

	private String userId;

	private UserServiceImpl() { }

	public static UserServiceImpl getInstance() {
		return userService;
	}

	public void setUser(String userId) {
		this.userId = userId;
	}

	public String userInfo() { //테스트용 메소드...
		User user = userRepository.find(userId);
		return "현재 UserService 에 로그인 되어있는 유저의 정보입니다 : " + user.toString();
	}

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

	//포인트 충전
	public void chargePoint(int point) {
		User user = userRepository.find(userId);
		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		MyDate date = user.getDate();
		String email = user.getEmail();
		int address = addressStringToInt(user.getAddress());
		String phoneNumber = user.getPhoneNumber();
		User updateUser = new User(id, password, name, date, address, point, email, phoneNumber);

		userRepository.update(updateUser);
		System.out.println(user.getName() + "님의 잔액이 " + point + "원 충전되었습니다.");
	}

	//다른 유저의 포인트를 변경하기 위한 메소드
	public void chargePoint(User user, int point) {
		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		MyDate date = user.getDate();
		String email = user.getEmail();
		int address = addressStringToInt(user.getAddress());
		String phoneNumber = user.getPhoneNumber();
		User updateUser = new User(id, password, name, date, address, point, email, phoneNumber);

		userRepository.update(updateUser);
	}

	// 나와 같은 이웃 찾기 (같은 지역)
	public void neighborFind() {
		User user = userRepository.find(userId);
		HashMap<String, User> userMap = userRepository.find(); //현재 회원가입 되어있는 모든 유저 반환

		String userAddress = user.getAddress();

		System.out.println("\n===== 나와 같은 지역에 거주하는 사람입니다. =====");
		for (String key : userMap.keySet()) {
			//현재 로그인한 유저와 동일한 주소를 갖는 유저를 찾는다.
			User tmpUser = userMap.get(key);
			if (userAddress.equals(tmpUser.getAddress())) {
				System.out.println("[" + key + "] 이름: " + tmpUser.getName() + ", 주소: " + tmpUser.getAddress() + ", 이메일: " + tmpUser.getEmail());
			}
		}
	}

	// 생일 축하
	public void birthDay(String userId) {
		User user = userRepository.find(userId);
		MyDate date = user.getDate();

		LocalDate localDate = LocalDate.now();
		String[] split = String.valueOf(localDate).split("-");
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);

		//생일인 경우
		if ((date.getMonth() == month) && (date.getDay() == day)) {
			System.out.println("\n===============================================================");
			System.out.println("     ||||||||||||      안녕하세요. " + user.getName() + " 님!    ||||||||||||" );
			System.out.println("  ||||||||||||  오늘은 " + year + "년 " + month + " 월 " + day + " 일 입니다!!    ||||||||||||");
			System.out.println("||||||||||||   " + user.getName() + "님의 생일을 진심으로 축하드립니다!!    ||||||||||||");
			System.out.println("===============================================================\n");
		}
	}
}