package com.edu.repository;

import java.util.HashMap;
import java.util.Map;

import com.edu.vo.MyDate;
import com.edu.vo.User;

public class UserRepository {

	////////////////////// 싱글톤으로 생성 //////////////////////
    private static final HashMap<String, User> users = new HashMap<>();

	// UserRepository 싱글톤으로 생성
	private static final UserRepository userRepository = new UserRepository();

	private UserRepository() {}

	public static UserRepository getInstance() {
		return userRepository;
	}

	//////////////////////////////////////////////////////////
	
	public void add(User user) {
		users.put(user.getId(), user);
	}

	//모든 유저 반환
	public HashMap<String, User> find() {
		return users;
	}

	public User find(String id) {
		for (String s : users.keySet()) {
			if (s.equals(id)) {
				return users.get(s);
			}
		}
		return null;
	}

	//Key 값만 가지고 유저 정보 수정 가능
	public void update(User user) {
		for (String s : users.keySet()) {
			//변경하려는 User의 ID 값과 동일한 key
			if (user.getId().equals(s)) {
				users.replace(s, user);
				System.out.println(user);
			}
		}
	}

	public void delete(String id) {
		users.remove(id);
	}

}
