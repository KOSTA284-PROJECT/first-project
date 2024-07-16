package com.edu.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.edu.service.LoginService;
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



	public void setHashMap(HashMap<String, User> user) {
		this.users = user;
	}

	public HashMap<String, User> getHashMap() {
		return users;
	}
	Set<User> userSet = new HashSet<>((Collection) users);

	public void add(String id, User user) {
		users.put(id,user);
		System.out.println( "유저는"+users);

    HashMap<String, User> users;

    public void setHashMap(HashMap<String, User> user) {
    	this.users = user;
    }

    public HashMap<String, User> getHashMap() {
    	return users;
    }

	public void add(String id, User user) {
		users.put(id, user);
	}

	public User findUser(String id){
		return users.get(id);
	public void find(HashMap<String, User> user) {


	}


	public User update(String id, User user) {
		users.replace(id, user);
		return user;
	}

	public void delete(String id, User user) {
		users.remove(id, user);
	}
  	// test
	User user1 = new User("1", "1234","user1", new MyDate(2000,10,10));
	//유저 조회 (id)
	public User findUser(String id) {
		return user1;
	}
}
