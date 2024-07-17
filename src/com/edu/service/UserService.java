package com.edu.service;

import com.edu.vo.User;

/**
 * UserService의 인터페이스입니다.
 * 유저 서비스의 기능을 제공합니다.
 */
public interface UserService {

    /**
     *포인트 충전 기능
     * @param id
     * @param chargePoint
     */
    void chargePoint(String id, int chargePoint);

    /**
     * 같은 지역 이웃을 찾는 기능
     */
    void neighborFind();
    /**
     * 유저의 생일과 같은 달에 포인트를 지급하는 기능
     */
    void celebrateBirthday(String id);
    /**
     * 포인트 충전 기능(ProductService에서 사용)
     */
    void chargePoint(User user, int point);

}