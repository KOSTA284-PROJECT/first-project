package com.edu.repository;

import java.util.HashMap;

import com.edu.vo.MyDate;
import com.edu.vo.User;

public class UserRepository {

	//String id, String password, String name, MyDate date
	// HashMap 선언 및 초기화

	public UserRepository(){

	}
	public static UserRepository getInstance(){
		return userRepo;
	}
	private static UserRepository userRepo = new UserRepository();
	HashMap<String, User> users = new HashMap<String,User>();

	String myId;

	public void setHashMap(HashMap<String, User> user) {
		this.users = user;
	}

	public HashMap<String, User> getHashMap() {
		return users;
	}

	public void add(String id, User user) {
		users.put(id,user);
		myId = id;
		System.out.println(myId);
	}

	public String findMyId(){
		return myId;
	}

	public User findUser(String id){
		return users.get(id);
	}

	public void update(String id, User user) {
		users.replace(id, user);
	}

	public void delete(String id, User user) {
		users.remove(id, user);
	}

}
