package com.edu.service;

import com.edu.repository.UserRepository;
import com.edu.vo.User;

public class LoginServiceImpl implements LoginService {

	// UserRepository 싱글톤으로 생성
	private static final UserRepository userRepository = UserRepository.getInstance();
	private static final UserService userService = UserServiceImpl.getInstance();

	////////////////////// 싱글톤으로 생성 //////////////////////
	private static final LoginServiceImpl loginService = new LoginServiceImpl();

	private LoginServiceImpl() { }

	public static LoginServiceImpl getInstance() {
		return loginService;
	}

	//로그인() -> 해당 유저의 ID 리턴
//	public String login(String id, String password) {
//		User user = userRepository.find(id);
//		System.out.println(user.getName() + "님 로그인 완료");
//		userService.birthDay(id);
//		return user.getId();
//	}
	
	//회원가입()
	public void addUser(User user) {
//		userRepository.add(user);
		System.out.println(user.getName() + "님 회원가입 완료");
	}
	
}
