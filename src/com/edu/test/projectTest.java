package com.edu.test;


import java.util.Scanner;
import com.edu.repository.UserRepository;
import com.edu.service.*;
import com.edu.vo.MyDate;
import com.edu.vo.User;


public class projectTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UserRepository userRepo = UserRepository.getInstance();
        UserServiceImpl userImpl = UserServiceImpl.getInstance();
//        users.put("user1", new User("user1", "password1", "John Doe", new MyDate(1988,7,16), "john.doe@example.com", "서울", "01012345678"));
//        users.put("user2", new User("user2", "password2", "Jane Smith", new MyDate(2000,9,22), "jane.smith@example.com", "경기", "01087654321"));
//        users.put("user3", new User("user3", "password3", "James", new MyDate(1970,3,5), "james@example.com", "인천", "01011223344"));
//        users.put("user4", new User("user4", "password4", "Bob", new MyDate(1996,7,16), "bob@example.com", "서울", "01099887766"));
        //
//        products.put(1, new Refrigerator("슈퍼냉장고", 40000, "냉장고중에서 최고 냉장고입니다." , "Refrigerator", 100));
//        products.put(2, new NoteBook("맥북m2프로", 20000, "애플에서 만든 좋은 노트북입니다." , "NoteBook", "Apple"));
//        products.put(3, new AirConditioner("벽걸이에어컨", 30000, "냉장고중에서 최고 냉장고입니다." , "AirConditioner", true));
//        products.put(4, new Refrigerator("허접냉장고", 40000, "냉장고중에서 최고 냉장고입니다." , "Refrigerator", 100));


        // ================== UserService 테스트 진행 ==================
        userRepo.add("user1", new User("user1", "password1", "John Doe", new MyDate(1988, 7, 17), 1, 1, "john.doe@example.com", "01012345678"));
        userRepo.add("user2", new User("user2", "password2", "Jane Smith", new MyDate(2000, 9, 22), 1, 1, "jane.smith@example.com", "01087654321"));
        userRepo.add("user3", new User("user3", "password3", "James", new MyDate(1970, 3, 5), 1, 1, "james@example.com", "01011223344"));
        userRepo.add("user4", new User("user4", "password4", "Bob", new MyDate(1996, 7, 16), 1, 1, "bob@example.com", "01099887766"));


        userImpl.celebrateBirthday("user1");


        userTest:
        while (true) {
            String menu = "";
            menu += "메인메뉴";
            menu += "메뉴를 선택하세요.";
            menu += "1. 포인트 충전";
            menu += "2. 우리 동네 주민 찾기";
            menu += "3. 회원탈퇴";
            System.out.println(menu);

            int num = sc.nextInt();
            if (num < 1 || 3 < num)
                continue;
            switch (num) {
                case 1:
                    System.out.println("충전금액을 확인해주세요.");
                    int point = sc.nextInt();
                    while (true) {
                        if (point > 0 || point < 500000) {
                            break;
                        } else {
                            System.out.println("입력을 확인하세요.");
                        }
                    }
                    userImpl.chargePoint("user1", point);
                    System.out.println(userRepo.findUser("user1"));
                    break;
                case 2:

                case 3:
                    System.out.println("정말 탈퇴 하실 생각이라면 1. 확인 을 눌러주세요.");
                int del = sc.nextInt();
                if(del == 1){
                    userRepo.delete("user1",userRepo.findUser("user1"));
                    System.out.println("서비스를 이용해주셔서 감사합니다.");
                    System.exit(0);
                }

            }

        }
    }
}
