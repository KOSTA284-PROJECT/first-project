package com.edu.test;

import com.edu.exception.NoBalanceException;
import com.edu.exception.NoFindProductException;
import com.edu.repository.ProductRepository;
import com.edu.repository.UserRepository;
import com.edu.service.*;
import com.edu.vo.*;

public class projectTest {

	public static void main(String[] args) {

        LoginService loginServiceImpl = LoginServiceImpl.getInstance();
        loginServiceImpl.addUser(new User("user1", "user1password", "BAEK", new MyDate(2000, 8, 23), 1));
        loginServiceImpl.addUser(new User("user2", "user2password", "Jones", new MyDate(1978, 10, 11), 2));
        loginServiceImpl.addUser(new User("user3", "user3password", "SON", new MyDate(1996, 3, 3), 2));
        loginServiceImpl.addUser(new User("user4", "user4password", "KIM", new MyDate(1988, 7, 16), 2));
        String user1 = loginServiceImpl.login("user1", "user1password");

        ProductService productService = ProductServiceImpl.getInstance();
        ProductRepository productRepository = ProductRepository.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        UserRepository userRepository = UserRepository.getInstance();

        System.out.println("\n============== id:user1 , BAEK 님이 로그인하셨습니다. ==============");
        ((ProductServiceImpl) productService).setUserId(user1);
        System.out.println(productService.userInfo());
//        ((UserServiceImpl) userService).setUser(user1);
//        System.out.println(userService.userInfo());
//
//        // BAEK 포인트 충전, 10만원
//        userService.chargePoint(100_000);
//        System.out.println(productService.userInfo());
//        System.out.println(userService.userInfo());

        //상품 추가 (카테고리 : 1.노트북 , 2.냉장고, 3.에어컨
//        productRepository.add(new NoteBook("맥북m2프로", 20000, "애플에서 만든 정말 좋은 노트북입니다.", 1, "Apple", userRepository.find(user1)));
//        productRepository.add(new Refrigerator("명품 냉장고", 40000, "냉장고중에서 명품 냉장고입니다.", 2, 500, userRepository.find(user1)));
//        productRepository.add(new AirConditioner("벽걸이 에어컨", 35000, "LG에서 만든 정말 좋은 벽결이 에어컨입니다..", 3, false, userRepository.find(user1)));
//        productRepository.add(new AirConditioner("최신형 슈퍼 울트라 메이크남극앤북극 에어컨", 150000000, "남극과 북극으로 만들만큼 시원한 에어컨입니다.", 3, true, userRepository.find(user1)));

        //상품 전체 조회
        productService.viewAllProduct();

        //상품 상세 조회
        productService.viewProductDetail(1);

        //내가 등록한 상품 조회
        productService.myProduct();

        System.out.println("\n=================================================================");
        System.out.println("================ id:user4 , KIM 님이 로그인하셨습니다. ==============");
        String user4 = loginServiceImpl.login("user4", "user4password");
        ((ProductServiceImpl) productService).setUserId(user4);
        System.out.println(productService.userInfo());
//        ((UserServiceImpl) userService).setUser(user4);
//        System.out.println(userService.userInfo());

        // SON 포인트 충전, 10만원
//        userService.chargePoint(100_000);
//        System.out.println(productService.userInfo());
//        System.out.println(userService.userInfo());

        //상품 추가 (카테고리 : 1.노트북 , 2.냉장고, 3.에어컨
//        productRepository.add(new NoteBook("맥북m1에어", 15000, "애플에서 만든 가성비 좋은 노트북입니다.", 1, "Apple", userRepository.find(user4)));
//        productRepository.add(new Refrigerator("일반 냉장고", 30000, "일반 냉장고입니다.", 2, 200, userRepository.find(user4)));
//        productRepository.add(new AirConditioner("스탠드 에어컨", 27000, "LG에서 만든 스탠드 에어컨입니다..", 3, true, userRepository.find(user4)));

        //상품 전체 조회
        productService.viewAllProduct();

        //상품 상세 조회
        productService.viewProductDetail(1);
        productService.viewProductDetail(4);

        try {
            //상품 이름 검색 (에어)
            productService.findProductByName("에어");

            //상품 이름 검색 (뾰로롱)
            productService.findProductByName("뾰로롱");

        } catch (NoFindProductException e) {
                System.out.println(e.getMessage());
        }

        //상품 카테고리 검색 (1번 : 노트북)
        productService.findProductByCategory(1);

        //내가 등록한 상품 조회
        productService.myProduct();

        //상품 구매 (user4가 user1의 맥북m2프로 구매)
        productService.buyProduct(1);

        //상품 구매 (user4가 user1의 최신형 슈퍼 울트라 메이크남극앤북극 에어컨 구매)
        try {
            productService.buyProduct(4);
        } catch (NoBalanceException e) {
            System.out.println(e);
        }

        //상품 전체 조회
        productService.viewAllProduct();

        System.out.println(productService.userInfo());

        //나와 같은 지역사람 찾기
//        userService.neighborFind();

	}

}
