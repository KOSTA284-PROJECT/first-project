package com.edu.service;

import com.edu.repository.UserRepository;
import com.edu.vo.MyDate;
import com.edu.vo.User;

public class UserServiceImpl implements UserService{
	public UserServiceImpl(){

	}
	public static UserServiceImpl getInstance(){
		return userservice;
	}
	private static UserServiceImpl userservice = new UserServiceImpl();

	UserRepository userRepo = UserRepository.getInstance();
	User user;

	public static final int FIRST_CHARGE = 5000;


	//유저 조회 (id)
	public void findUser() {
		String id = user.getId();
		if (user == null) {
			System.out.println("유저가 존재하지 않습니다.");

		} else {
			user = userRepo.findById(id);
			if (user == null) {
				System.out.println("유저가 존재하지 않습니다.");
			}

		}
	}
	//포인트 충전
	@Override
	public void chargePoint(String id, int chargePoint) {
		User userToCharge = userRepo.findById(id);
			if (userToCharge != null) {
				if(!userToCharge.firstCharge()) {
					userToCharge.chargePoint(FIRST_CHARGE); // 예시로 500 포인트를 충전합니다.
					userToCharge.setfirstCharge(true);
					System.out.println(userToCharge.getName() + "님, 첫 충전 5,000원이 되었습니다.");
					userToCharge.chargePoint(chargePoint);
					userRepo.update(id, userToCharge);
				}
				else {userToCharge.chargePoint(chargePoint);
					userRepo.update(id, userToCharge);
			} }else {
				System.out.println("해당 ID의 사용자를 찾을 수 없습니다.");
			}

	}

	//멤버쉽 10,000원 권 구매 시 결제 건당 500원 할인.
	@Override
	public void buyMembership() {

	}
	//주소가 같은 주민 찾기 값을 받을 때는 int로 1. 서울,2.경기도,3.인천
	@Override
	public void searchNeighbor() {

	}
	//생일 축하 메세지 출력 및 포인트 5000원 추가
	@Override
	public void celebrateBirthday() {

	}



}
