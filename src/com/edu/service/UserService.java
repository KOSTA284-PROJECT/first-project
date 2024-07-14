package com.edu.service;

import com.edu.repository.UserRepository;
import com.edu.vo.MyDate;
import com.edu.vo.User;

public class UserService {
	public UserService(){

	}
	public static UserService getInstance(){
		return userservice;
	}
	private static UserService userservice = new UserService();
	User user;

	//유저 등록
	public void addUser(String id, String password, String name, MyDate date) {
		UserRepository.getInstance().add(id,new User(id,password,name,date));
		user = UserRepository.getInstance().find(id);

	}

	//유저 수정
	public void updateUser(String password, String mail, String address, String phoneNumber) {

		if (password != null) {
			user.setPassword(password);
		}
		if (mail != null) {
			user.setEmail(mail);
		}
		if (address != null) {
			user.setAddress(address);
		}
		if (phoneNumber != null) {
			user.setPhoneNumber(phoneNumber);
		}
		User updatedUser = new User(user.getId(),password,user.getName(),user.getDate(), user.getPoint(),mail,address,phoneNumber);
		UserRepository.getInstance().update(updatedUser.getId(), updatedUser );
		updatedUser = user;
	}

	//유저 삭제 -> 회원 탈퇴
	public void deleteUser() {
		UserRepository.getInstance().delete(user.getId(),user);
	}

	//유저 조회 (id)
	public User findUser() {
		String id = user.getId();
		if (user == null) {
			System.out.println("유저가 존재하지 않습니다.");
			return null;
		} else {
			user = UserRepository.getInstance().find(id);
			if (user == null) {
				System.out.println("유저가 존재하지 않습니다.");
			}
			return user;
		}
	}

	//포인트 충전
	public void chargePoint(int point) {


	}

}
