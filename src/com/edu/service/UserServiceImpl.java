package com.edu.service;

import com.edu.repository.UserRepository;
import com.edu.vo.MyDate;
import com.edu.vo.User;

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

	//멤버쉽 10,000원 권 구매 시 결제 건당 500원 할인.
	@Override
	public void buyMembership() {

	}
	//주소가 같은 주민 찾기 값을 받을 때는 int로 1. 서울,2.경기도,3.인천
	@Override
	public void searchNeighbor(String id,int num) {
		HashMap<String, User> mapTest = userRepo.getHashMap();
		Set<Map.Entry<String,User>> entrySet = mapTest.entrySet();

		switch (num) {
			case 1:
				for (Map.Entry<String, User> entry : entrySet) {
					if (entrySet.contains(mapTest.get(id).getAddress())) {
							System.out.println(entry.getValue());
					}
				}
			case 2:

			case 3:

		}
	}

	//생일 축하 메세지 출력 및 포인트 5000원 추가
	@Override
	public void celebrateBirthday() {

	}



}
