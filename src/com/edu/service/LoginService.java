package com.edu.service;

import com.edu.vo.User;

public interface LoginService {

    //회원가입 메소드
    void signUp(User user);

    //로그인 메소드
    String login(String id, String password);

    //아이디 찾기 메소드(R)
    void findId(String userName, String userPhoneNumber);

    //패스워드 찾기 메소드(R)
    void findPw(String userId, String userName, String phoneNumber);

    //오렌지 마켓 메인페이지 출력용 메소드
    void printMainPage();

    //오렌지 마켓 로그인메뉴 출력용 메소드
    void printLoginMenu();

    //로그인 성공 후 로그인 메뉴 화면
    void printMainMenu();
}
