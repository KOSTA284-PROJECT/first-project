package com.edu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.edu.repository.ProductRepository;
import com.edu.repository.UserRepository;
import com.edu.service.LoginService;
import com.edu.service.ProductService;
import com.edu.service.UserServiceImpl;
import com.edu.vo.MyDate;
import com.edu.vo.Product;
import com.edu.vo.User;

public class projectTest {

	public static void main(String[] args) {
		// 더미 사용자 데이터 생성
        HashMap<String, User> users = new HashMap<>();
        Map<Integer, Product> products = new HashMap<>();
        UserRepository userRepository = new UserRepository();
        ProductRepository productRepository = new ProductRepository();
        UserRepository userRepo = UserRepository.getInstance();
        UserServiceImpl userImpl = UserServiceImpl.getInstance();

        userRepo.add("user1", new User("user1", "password1", "John Doe", new MyDate(1988,7,12),0,"e","서울","010"));
        userRepo.add("user2", new User("user2", "password2", "Jane Smith", new MyDate(2000,9,22),0,"e","서울","010"));
        userRepo.add("user3", new User("user3", "password3", "James", new MyDate(1970,3,5),0,"e","서울","010"));


//        products.put(1, new Refrigerator("슈퍼냉장고", 40000, "냉장고중에서 최고 냉장고입니다." , "Refrigerator", 100));
//        products.put(2, new NoteBook("맥북m2프로", 20000, "애플에서 만든 좋은 노트북입니다." , "NoteBook", "Apple"));
//        products.put(3, new AirConditioner("벽걸이에어컨", 30000, "냉장고중에서 최고 냉장고입니다." , "AirConditioner", true));
//        products.put(4, new Refrigerator("허접냉장고", 40000, "냉장고중에서 최고 냉장고입니다." , "Refrigerator", 100));

//        // 유저DB, 상품DB에 값 저장
//        userRepository.setHashMap(users);
//        productRepository.setHashMap(products);
//
//        // 저장이 잘 되었는가 테스트
//        for (String key : userRepository.getHashMap().keySet()) {
//        	System.out.println(userRepository.getHashMap().get(key));
//        }
//
//        for (Integer key : productRepository.getHashMap().keySet()) {
//        	System.out.println(productRepository.getHashMap().get(key));
//        }
        
        // ================== LoginService 테스트 진행 ==================
        LoginService loginService = new LoginService();
        //loginService.login(id, pw)
        
        
        
        
        
        
        
        // ================== UserService 테스트 진행 ==================

        Scanner in = new Scanner(System.in);
            userRepo.add("user1", new User("user1","password1", "John Doe", new MyDate(1988,7,12)));


//            for (int i = 0; i<3;i++) {
//                System.out.println("충전할 금액을 알려주세요.");
//                int chargepoint = in.nextInt();
//                userImpl.chargePoint("user1", chargepoint);
//
//                System.out.println("test:" + userRepo.findUser("user1"));
//            }
        int num = in.nextInt();
        userImpl.searchNeighbor("user1",num);
        System.out.println();
        
        
        // ================== ProductService 테스트 진행 ==================
        ProductService productService = new ProductService();

	}

}
