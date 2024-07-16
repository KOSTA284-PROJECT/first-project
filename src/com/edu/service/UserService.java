package com.edu.service;

import com.edu.repository.UserRepository;
import com.edu.vo.MyDate;
import com.edu.vo.User;

public class UserService {
	
	UserRepository userRepository = new UserRepository();

	// test
	User[] users = new User[5];

	//유저 등록
	public void addUser(String id, String password, String name, MyDate date) {
		
	}
	
	//유저 수정
	public void updateUser(User user, User changeUser) {
		
	}
	
	//유저 삭제 -> 회원 탈퇴
	public void deleteUser(User user) {
		
	}

	
	
	//포인트 충전
	public void chargePoint(int point) {
		
	}

}
