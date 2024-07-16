package com.edu.service;

import com.edu.vo.User;

public interface LoginService {

    //로그인() -> 해당 유저의 ID 리턴
    String login(String id, String password);

    //회원가입()
    void addUser(User user);
}
