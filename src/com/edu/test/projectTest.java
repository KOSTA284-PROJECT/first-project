package com.edu.test;

import java.util.*;

import com.edu.impl.ProductServiceImpl;
import com.edu.repository.ProductRepository;
import com.edu.repository.UserRepository;
import com.edu.service.LoginService;
import com.edu.service.ProductService;
import com.edu.service.UserService;
import com.edu.vo.AirConditioner;
import com.edu.vo.NoteBook;
import com.edu.vo.Product;
import com.edu.vo.Refrigerator;
import com.edu.vo.User;

public class projectTest {

    public static void main(String[] args) {
        // 더미 사용자 데이터 생성
        HashMap<String, User> users = new HashMap<>();
        Map<Integer, Product> products = new HashMap<>();
        UserRepository userRepository = new UserRepository();
        ProductRepository productRepository = new ProductRepository();
        // 유저DB, 상품DB에 값 저장
//        userRepository.setHashMap(users);
//        productRepository.setHashMap(products);
        // 저장이 잘 되었는가 테스트
//        for (String key : userRepository.getHashMap().keySet()) {
//        	System.out.println(userRepository.getHashMap().get(key));
//        }
//        for (Integer key : productRepository.getHashMap().keySet()) {
//        	System.out.println(productRepository.getHashMap().get(key));
//        }

        // ================== LoginService 테스트 진행 ==================
        LoginService loginService = new LoginService();
        //loginService.login(id, pw)







        // ================== UserService 테스트 진행 ==================
        UserService userService = new UserService();






        // ================== ProductService 테스트 진행 ==================
        ProductServiceImpl productService = ProductServiceImpl.getInstance();
        ProductRepository productRepo = ProductRepository.getInstance();

        Scanner sc = new Scanner(System.in);

        productTest: while(true){
            String menu = "";
            menu += "[메인메뉴]\n번호를 선택하세요.\n";
            menu += "1.상품등록  2.상품전체조회  3.상품검색";

            int number;
            while(true) {
                System.out.println(menu);
                try {
                    number = sc.nextInt();

                    if(number > 0 && number <= 4) {
                        break;
                    }else{
                        System.out.println(menu);
                    }
                }catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    sc.next();
                }
            }

            switch (number) {
                case 1:
                    // 상품 등록
                    System.out.println("상품이름 : ");
                    String name = sc.next();
                    System.out.println("상품가격 : ");
                    int price = sc.nextInt();
                    System.out.println("상품설명 : ");
                    String info = sc.next();

                    System.out.println("상품의 카테고리를 선택하세요 : ");
                    System.out.println("1.냉장고  2.에어컨  3.노트북");
                    int categoryNum = sc.nextInt();

                    // 잘못된 번호 입력 처리
                    while (true){
                        if(categoryNum > 0 && categoryNum <= 3) {
                            break;
                        }else{
                            System.out.println("다시 입력하세요.");
                        }
                    }

                    // 카테고리 번호 입력 처리
                    // 냉장고
                    if(categoryNum == 1) {
                        System.out.println("냉장고의 사이즈를 입력하세요.");
                        int capacity = sc.nextInt();
                        productRepo.add(new Refrigerator(name, price, info , "Refrigerator", capacity, userRepository.findUser("1")));
                    }
                    // 에어컨
                    if(categoryNum == 2) {
                        boolean stand;
                        while (true) {
                            System.out.println("에어컨의 유형을 선택하세요");
                            System.out.println("1.스탠드형   2.벽걸이형");
                            int standNum = sc.nextInt();
                            if (standNum == 1 || standNum == 2) {
                                stand = standNum == 1; // 에어컨 유형
                                break;
                            } else {
                                System.out.println("다시 입력하세요.");
                            }
                        }
                        productRepo.add(new AirConditioner(name, price, info , "AirConditioner", stand, userRepository.findUser("1")));
                    }
                    // 노트북
                    if(categoryNum == 3) {
                        System.out.println("노트북 브랜드를 입력하세요.");
                        String company = sc.next();
                        productRepo.add(new NoteBook(name, price, info , "NoteBook", company, userRepository.findUser("1")));
                    }
                    System.out.println("상품 등록이 완료되었습니다.");
                    break;

                case 2:
                    // 상품 전체조회
                    // 전체조회
                    try{
                        System.out.println("===== 상품전체조회 결과 =====");
                        productService.viewAllProduct();
                    }catch (Exception e) {
                        System.out.println("전체조회 : " + e);
                    }

                    // TODO 선택한 번호의 상품 상세 정보 입력 필요
                    System.out.println("===== 상품의 번호를 선택하세요. (상품 상세정보 출력 로직작성필요) =====");
//                    while (true) {
//
//                    }

                    break;

                case 3:
                    // 상품 검색
                    int optionNum = 0;

                    // 상품 검색 옵션 선택
                    while (true) {
                        System.out.println("===== 상품 검색 옵션을 선택하세요.=====");
                        System.out.println("1. 상품명 텍스트 검색   2. 상품 카테고리 검색");
                        optionNum = sc.nextInt();
                        // 잘못된 입력 처리
                        if (optionNum > 0 && optionNum <= 2) {
                            break;
                        } else {
                            System.out.println("다시 입력하세요.");
                        }
                    }

                    // 1. 텍스트 검색(상품명)
                    if(optionNum == 1) {
                        System.out.println("검색할 상품의 이름을 입력하세요.");
                        String productName =  sc.next();

                        try{
                            System.out.println("======= " + productName + " 검색 결과 =======");
                            productService.findProductByName(productName);
                            // TODO 상세조회 추가 필요
                        }catch (Exception e) {
                            System.out.println("텍스트검색 e : " + e);
                        }
                    }else {
                        // 2. 카테고리 검색
                        while (true) {
                            System.out.println("상품의 카테고리를 선택하세요 : ");
                            System.out.println("1.냉장고  2.에어컨  3.노트북");
                            int categoryOption = sc.nextInt();
                            // 잘못된 입력 처리
                            if (categoryOption > 0 && categoryOption <= 3) {
                                break;
                            } else {
                                System.out.println("다시 입력하세요.");
                            }
                        }

                        // 카테고리 검색처리
                        try{
                            System.out.println("======= " + "Refrigerator" +" 카테고리 조회 결과 =======");
                            productService.findProductByCategory("Refrigerator");
                            // TODO 상세조회 추가 필요
                        }catch (Exception e) {
                            System.out.println("카테고리 검색 e: " + e);
                        }
                    }

                    break;

                case 4:
                     //마이페이지
                    break;
            }
        }
    }
}
