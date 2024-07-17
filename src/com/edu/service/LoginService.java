package com.edu.service;

import com.edu.vo.User;

/**
 * LoginService의 인터페이스입니다.
 * 로그인 서비스의 기능을 제공합니다.
 */
public interface LoginService {
    /**
     * 회원가입 기능
     * @param user 유저 객체를 생성합니다.
     */
    void signUp(User user);

    /**
     * 로그인 기능
     * @param id 아이디
     * @param password 패스워드
     * @return 로그인을 성공하면 ID반환, 실패시 ""반환
     */
    String login(String id, String password);

    /**
     * 아이디 찾기 기능
     * @param userName 유저 이름
     * @param userPhoneNumber 유저 휴대폰 번호
     */
    void findId(String userName, String userPhoneNumber);

    /**
     * 패스워드 찾기 기능
     * @param userId 유저 ID
     * @param userName 유저 이름
     * @param phoneNumber 유저 휴대폰 번호
     */
    void findPw(String userId, String userName, String phoneNumber);

    /**
     * 오렌지 마켓 메인페이지 출력 기능
     */
    void printMainPage();

    /**
     * 오렌지 마켓 로그인메뉴 출력 기능
     */

    void printLoginMenu();

    /**
     * 로그인 성공 후 메인메뉴 화면 출력 기능
     */
    void printMainMenu();
}
