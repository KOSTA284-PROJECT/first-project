package com.edu.service;

import com.edu.repository.UserRepository;
import com.edu.vo.MyDate;
import com.edu.vo.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UserServiceImpl implements UserService{
	public UserServiceImpl(){}
	public static UserServiceImpl getInstance(){
		return userservice;
	}
	private static UserServiceImpl userservice = new UserServiceImpl();

	UserRepository userRepo = UserRepository.getInstance();



	public static final int CHARGE = 5000;
	String myId;
	public void setId(String id) {
		this.myId = id;
	}
	//포인트 충전
	@Override
	public void chargePoint(String id, int chargePoint) {
		User user = userRepo.findUser(id);
		if (user != null) {
				if(!user.firstCharge()) {
					user.chargePoint(CHARGE);// 첫 충전 시 5,000 포인트를 충전
					System.out.println(user.getName() + "님, 첫 충전 5,000원이 충전되었습니다.");
					userRepo.update(myId, user);
					user.chargePoint(chargePoint);
					userRepo.update(myId, user);
					user.setfirstCharge(true);
				}else {
					user.chargePoint(chargePoint);
					userRepo.update(myId,user);
				}
		} else {
				System.out.println("해당 ID의 사용자를 찾을 수 없습니다.");
			}
	}


	//주소가 같은 주민 찾기 값을 받을 때는 int로 1. 서울,2.경기도,3.인천
	@Override
	public void searchNeighbor(String id, int num) {
		User user = userRepo.findUser(id);
		if (user == null) {
			System.out.println("사용자를 찾을 수 없습니다.");
			return;
		}

		String targetAddress = "";
		switch (num) {
			case 1:
				targetAddress = "서울";
				break;
			case 2:
				targetAddress = "인천";
				break;
			case 3:
				targetAddress = "경기도";
				break;
			default:
				System.out.println("잘못된 지역 번호입니다.");
				return;
		}

		System.out.println(targetAddress + " 지역에 사는 이웃:");
		for (Map.Entry<String, User> entry : userRepo.getHashMap().entrySet()) {
			User neighbor = entry.getValue();
			if (neighbor.getAddress().equals(targetAddress)) {
				System.out.println("ID: " + neighbor.getId() + ", 이름: " + neighbor.getName());
			}
		}
	}

	//생일 축하 메세지 출력 및 포인트 5000원 추가
	@Override
	public void celebrateBirthday(String id) {
		LocalDate now = LocalDate.now();
		User user = userRepo.findUser(id);
		int nowDay = now.getMonthValue();
		System.out.println("날짜" + nowDay);
		if (nowDay == user.getDate().getMonth()){
			System.out.println("생일 축하합니다.");
			user.chargePoint(CHARGE);
			userRepo.update(myId, user);
			System.out.println(user);
		}

	}

}
