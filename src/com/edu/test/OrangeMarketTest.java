package com.edu.test;

import com.edu.repository.ProductRepository;
import com.edu.repository.UserRepository;
import com.edu.service.*;
import com.edu.vo.*;

import java.util.Scanner;

//진짜 Test 클래스...
public class OrangeMarketTest {
    public static void main(String[] args) {
        LoginService loginService = LoginServiceImpl.getInstance();
        UserRepository userRepository = UserRepository.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        ProductRepository productRepository = ProductRepository.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();

        String loginUserId = "" ;

        while (true) {
            // 로그인 서비스
            while(true) {
                loginUserId = Login();
                //userId 값이 반환 되면 로그인 서비스를 종료
                if (loginUserId.equals("loop"))
                    continue;

                //로그인이 완료되었다면..
                ((UserServiceImpl)userService).setUser(loginUserId);
                ((ProductServiceImpl)productService).setUser(loginUserId);

                // 메인메뉴 서비스
                while (true) {
                    Scanner sc = new Scanner(System.in);
                    loginService.printMainMenu();
                    int menu = sc.nextInt();

                    switch (menu) {
                        case 1:
                            //상품 등록
                            System.out.println("======== 상품등록 ========");
                            productRepository.add(new Refrigerator("슈퍼 냉장고", 40000, "냉장고중에서 최고 냉장고입니다." , "Refrigerator", 100, userRepository.find("user1")));
                            productRepository.add(new NoteBook("맥북m2 프로", 20000, "애플에서 만든 좋은 노트북입니다." , "NoteBook", "Apple", userRepository.find("user2")));
                            productRepository.add(new NoteBook("맥북m1 에어", 15000, "애플에서 만든 노트북입니다." , "NoteBook", "Apple", userRepository.find("user2")));
                            productRepository.add(new AirConditioner("벽걸이 에어컨", 30000, "냉장고중에서 최고 냉장고입니다." , "AirConditioner", true, userRepository.find("user3")));
                            productRepository.add(new Refrigerator("허접 냉장고", 40000, "일반 냉장고입니다." , "Refrigerator", 100, userRepository.find("user4")));
                            break;
                        case 2:
                            //상품 전체 조회
                            try {
                                System.out.println("===== 상품전체조회 결과 =====");
                                productService.viewAllProduct();
                            } catch (Exception e) {
                                System.out.println("전체조회 : " + e);
                            }
                            break;
                        case 3:
                            //상품 검색 로직
                            int optionNum = 0;

                            //상품 검색 옵션 선택
                            optionNum = productOptionSelect();

                            //1. 텍스트 검색(상품명)
                            if (optionNum == 1) {
                                System.out.println("검색할 상품의 이름을 입력하세요.");
                                String productName = sc.next();

                                try {
                                    System.out.println("======= " + productName + " 검색 결과 =======");
                                    productService.findProductByName(productName);
                                    System.out.print("상세 조회 하실 상품의 번호를 입력해주세요 : ");
                                    int productNum = sc.nextInt();
                                    productService.viewProductDetail(productNum);
                                    //구매, 수정, 삭제 로직 필요

                                } catch (Exception e) {
                                    System.out.println("텍스트검색 e : " + e);
                                }
                            } else {
                                // 2. 카테고리 검색
                                int categoryOption = 0;
                                while (true) {
                                    System.out.println("상품의 카테고리를 선택하세요 : ");
                                    System.out.println("1.냉장고  2.에어컨  3.노트북");
                                    categoryOption = sc.nextInt();
                                    // 잘못된 입력 처리
                                    if (categoryOption > 0 && categoryOption <= 3) {
                                        break;
                                    } else {
                                        System.out.println("다시 입력하세요.");
                                    }
                                }

                                //카테고리 검색처리
                                try {
                                    System.out.println("======= 카테고리 조회 결과 =======");

                                    productService.findProductByCategory("Refrigerator");
                                    // TODO 상세조회 추가 필요
                                    System.out.print("상세 조회하실 상품의 번호를 입력해주세요 : ");
                                    int productNum = sc.nextInt();
                                    productService.viewProductDetail(productNum);
                                    //구매, 수정, 삭제 로직 필요
                                } catch (Exception e) {
                                    System.out.println("카테고리 검색 e: " + e);
                                }
                            }

                            break;
                        case 4:
                            //마이페이지
                    }
                }
            }
        }
    }

    static String Login() {
        LoginService loginService = LoginServiceImpl.getInstance();
        Scanner sc = new Scanner(System.in);
        loginService.printMainPage();
        loginService.printLoginMenu();
        int menu = sc.nextInt();

        switch (menu) {
            case 1:
                String loginId = loginService.login("user2", "user2pw");
                return loginId;
            case 2:
                loginService.signUp(new User("user1", "user1pw", "KIM", new MyDate(1987, 9, 22), 1));
                loginService.signUp(new User("user2", "user2pw", "BAEK", new MyDate(2000, 7, 17), 1));
                loginService.signUp(new User("user3", "user3pw", "LEE", new MyDate(1986, 5, 5), 2));
                loginService.signUp(new User("user4", "user4pw", "HONG", new MyDate(1998, 2, 14), 2));
                loginService.signUp(new User("user5", "user5pw", "PARK", new MyDate(1990, 12, 30), 3));
                break;
            case 3:
                //ID 찾기..
                break;
            case 4:
                //PW 찾기
                break;
            case 5:
                //종료
                System.exit(0);
        }

        return "loop";
    }

    static int productOptionSelect() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("===== 상품 검색 옵션을 선택하세요.=====");
            System.out.println("1. 상품명 텍스트 검색   2. 상품 카테고리 검색");
            int optionNum = sc.nextInt();
            // 잘못된 입력 처리
            if (optionNum > 0 && optionNum <= 2) {
                return optionNum;
            } else {
                System.out.println("다시 입력하세요.");
            }
        }
    }

    //상품 구매,수정,삭제 로직
    static void productLogin(String userId, int productId) {

//        if (userId.equals())
    }
}
