package com.edu.service;

import com.edu.vo.User;

public interface LoginService {

	// 회원가입 메소드
	public void signUp(User user);

    // 로그인 메소드
    public String login(String id, String password);
    
    // 아이디 찾기 메소드(R)
	public void findId(String userName, String userPhoneNumber);
    
    // 패스워드 찾기 메소드(R)
	public void findPw(String userId, String userName, String phoneNumber);
}
