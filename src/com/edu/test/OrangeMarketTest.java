package com.edu.test;

import com.edu.exception.NoBalanceException;
import com.edu.repository.ProductRepository;
import com.edu.repository.UserRepository;
import com.edu.service.*;
import com.edu.vo.*;

import java.util.Scanner;

public class OrangeMarketTest {
    public static void main(String[] args) {
        LoginService loginService = LoginServiceImpl.getInstance();
        UserRepository userRepository = UserRepository.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        ProductRepository productRepository = ProductRepository.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();

        String loginUserId = "" ;
        boolean loginFlag = false;

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
                    userService.celebrateBirthday(loginUserId);
                    switch (menu) {
                        case 1:
                            //상품 등록
                            System.out.println("======== 상품등록 ========");
                            productRegister();
                            break;
                        case 2:
                            productAll(loginUserId);
                            break;
                        case 3:
                            productSearch(loginUserId);
                            break;
                        case 4:
                            myPage(loginUserId);
                            break;
                        case 0:
                            //로그아웃
                            loginFlag = true;
                            break;
                    }

                    if (loginFlag) break;
                }
            }
        }
    }

    static void myPage(String loginUserId) {
        Scanner sc = new Scanner(System.in);
        UserRepository userRepository = UserRepository.getInstance();
        UserService userService = UserServiceImpl.getInstance();

        //마이페이지
        while (true) {
            User user = userRepository.find(loginUserId);
            System.out.println("=================================");
            System.out.println("[ 내 정보 ]");
            System.out.println("이름: " + user.getName());
            System.out.println("현재 잔액: " + user.getPoint());
            System.out.println("지역: " + user.getAddress());
            System.out.println("생일: " + user.getDate());
            System.out.println("=================================\n");

            String mypage = "";
            mypage += "메인메뉴 선택하세요.\n";
            mypage += "1. 포인트 충전\n";
            mypage += "2. 우리 동네 주민 찾기\n";
            mypage += "3. 회원탈퇴\n";
            mypage += "0. 뒤로가기\n";
            System.out.println(mypage);

            int num = sc.nextInt();
            if (num < 0 || 3 < num)
                continue;
            switch (num) {
                case 1:
                    System.out.println("충전금액을 확인해주세요.");
                    int point = sc.nextInt();
                    while (true) {
                        if (point > 0 || point < 500000)
                            break;
                        else
                            System.out.println("입력을 확인하세요.");
                    }
                    userService.chargePoint(loginUserId, point);
                    System.out.println(userRepository.find(loginUserId));
                    break;
                case 2:
                    userService.neighborFind();
                    break;
                case 3:
                    System.out.println("정말 탈퇴 하실 생각이라면 1. 확인 을 눌러주세요.");
                    int del = sc.nextInt();
                    if(del == 1){
                        userRepository.delete(loginUserId);
                        System.out.println("서비스를 이용해주셔서 감사합니다.");
                        System.exit(0);
                    }
                    break;
                case 0:
                    //뒤로가기
                    break;
            }
            break;
        }
    }

    static void productRegister() {
        ProductRepository productRepository = ProductRepository.getInstance();
        UserRepository userRepository = UserRepository.getInstance();

        productRepository.add(new Refrigerator("슈퍼 냉장고", 40000, "냉장고중에서 최고 냉장고입니다." , "Refrigerator", 100, userRepository.find("user1")));
        productRepository.add(new NoteBook("맥북m2 프로", 20000, "애플에서 만든 좋은 노트북입니다." , "NoteBook", "Apple", userRepository.find("user2")));
        productRepository.add(new NoteBook("맥북m1 에어", 15000, "애플에서 만든 노트북입니다." , "NoteBook", "Apple", userRepository.find("user2")));
        productRepository.add(new NoteBook("삼성 노트북", 15000, "삼성에서 만든 노트북입니다." , "NoteBook", "SAMSUNG", userRepository.find("user3")));
        productRepository.add(new AirConditioner("벽걸이 에어컨", 30000, "냉장고중에서 최고 냉장고입니다." , "AirConditioner", true, userRepository.find("user3")));
        productRepository.add(new Refrigerator("허접 냉장고", 40000, "일반 냉장고입니다." , "Refrigerator", 100, userRepository.find("user4")));
    }

    static void productAll(String loginUserId) {
        Scanner sc = new Scanner(System.in);
        ProductService productService = ProductServiceImpl.getInstance();

        //상품 전체 조회
        try {
            System.out.println("===== 상품전체조회 결과 =====");
            productService.viewAllProduct();
            System.out.print("상세 조회 하실 상품의 번호를 입력해주세요 : ");
            int productNum = sc.nextInt();
            productService.viewProductDetail(productNum);
            //구매, 수정, 삭제 로직 필요
            productLogic(loginUserId, productNum);
        } catch (Exception e) {
            System.out.println("전체조회 : " + e);
        }
    }

    static void productSearch(String loginUserId) {

        Scanner sc = new Scanner(System.in);
        ProductService productService = ProductServiceImpl.getInstance();

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
                productLogic(loginUserId, productNum);
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
            String categoryName = "";
            try{
                System.out.println("======= 카테고리 조회 결과 =======");
                if(categoryOption == 1)
                    categoryName = "Refrigerator";
                else if(categoryOption == 2)
                    categoryName = "AirConditioner";
                else if(categoryOption == 3)
                    categoryName = "NoteBook";

                productService.findProductByCategory(categoryName);

                //상세 조회
                System.out.print("상세 조회 하실 상품의 번호를 입력해주세요 : ");
                int productNum = sc.nextInt();
                productService.viewProductDetail(productNum);
                productLogic(loginUserId, productNum);
            } catch (Exception e) {
                System.out.println("카테고리 검색 e: " + e);
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
    static void productLogic(String userId, int productId) {
        Scanner sc = new Scanner(System.in);
        ProductRepository productRepository = ProductRepository.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();

        Product product = productRepository.find(productId); //해당 상품
        String productName = product.getName();
        String category = product.getCategory();
        User user = product.getUser();

        int optionNum = 0;

        //내가 등록한 상품이라면,,,
        if (userId.equals(user.getId())) {
            optionNum = sc.nextInt();
            switch (optionNum) {
                case 1:
                    System.out.println("수정하실 가격을 입력하세요: ");
                    int updatePrice = sc.nextInt();
                    sc.nextLine();
                    System.out.println("수정하실 정보를 입력하세요: ");
                    String updateInfo = sc.nextLine();

                    if (category.equals("Refrigerator")) {
                        productRepository.update(productId, new Refrigerator(productName, updatePrice, updateInfo, category, user));
                    } else if (category.equals("AirConditioner")) {
                        productRepository.update(productId, new AirConditioner(productName, updatePrice, updateInfo, category, user));
                    } else if (category.equals("NoteBook")) {
                        productRepository.update(productId, new NoteBook(productName, updatePrice, updateInfo, category, user));
                    }
                    break;
                case 2:
                    productRepository.delete(productId);
                    break;
                case 0:
                    break;
            }
        } else { //내가 등록한 상품이 아니라면,,,
            optionNum = sc.nextInt();
            switch (optionNum) {
                case 1:
                    try {
                        productService.buyProduct(productId);
                    } catch (NoBalanceException e) {
                        System.out.println(e);
                    }
                    break;
                case 0:
                    break;
            }
        }
    }
}