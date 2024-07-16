package com.edu.service;

import com.edu.vo.User;

public interface UserService {

    //테스트용 메소드...
    String userInfo();

    //포인트 충전
    void chargePoint(int point);

    //다른 유저의 포인트를 변경하기 위한 메소드
    void chargePoint(User user, int point);

    // 생일 축하
    void birthDay(String userId);

    // 나와 같은 이웃 찾기 (같은 지역)
    void neighborFind();
}
