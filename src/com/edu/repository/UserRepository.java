package com.edu.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import com.edu.vo.User;

public class UserRepository {

    //String id, String password, String name, MyDate date
    // HashMap 선언 및 초기화

    //싱글톤 구현
    public UserRepository() {

    }
    public static UserRepository getInstance() {
        return userRepo;
    }
    private static UserRepository userRepo = new UserRepository();


    //user전체 정보
    HashMap<String, User> users = new HashMap<String, User>();


    public void setHashMap(HashMap<String, User> user) {
        this.users = user;
    }

    public HashMap<String, User> getHashMap() {
        return users;
    }

    //주소를 출력을 위한 set


    public void add(String id, User user) {
        users.put(id, user);
    }

    public User findUser(String id) {
        return users.get(id);
    }

    public User update(String id, User user) {
        users.replace(id, user);
        return user;
    }

    public void delete(String id, User user) {
        users.remove(id, user);
    }
}