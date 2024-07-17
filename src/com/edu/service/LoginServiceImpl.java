package com.edu.service;

import java.nio.file.LinkOption;
import java.time.Instant;
import java.util.HashMap;

import com.edu.repository.UserRepository;
import com.edu.vo.MyDate;
import com.edu.vo.User;

/**
 * LoginService 인터페이스의 구현 클래스입니다.
 * 로그인 서비스 기능을 제공합니다.
 */
public class LoginServiceImpl implements LoginService {

	/**
	 * UserRepository의 싱글톤 인스턴스를 생성합니다.
	 */
	private UserRepository userRepository = UserRepository.getInstance();
	/**
	 * LoginServiceImpl 클래스의 유일한 인스턴스를 생성합니다.
	 */
	private static LoginServiceImpl login = new LoginServiceImpl();

	/**
	 * LoginServiceImpl의 기본 생성자.
	 * <p>
	 * 생성자를 private으로 지정하여 외부에서 새로운 인스턴스를 생성하지 못하도록 합니다.
	 * </p>
	 */
	private LoginServiceImpl() {}

	/**
	 * LoginServiceImpl의 유일한 인스턴스를 반환합니다.
	 * <p>
	 * 이 메서드는 싱글톤 패턴을 구현하며, 항상 동일한 인스턴스를 반환합니다.
	 * </p>
	 *
	 * @return LoginServiceImpl의 유일한 인스턴스
	 */
	public static LoginServiceImpl getInstance() {
		return login;
	}

	/**
	 * 회원가입 기능
	 * @param user 유저 객체를 생성하고 UserRepository에 정보를 추가합니다.
	 */
	@Override
	public void signUp(User user) {
		//회원가입으로 받은 user 정보 userRepository에 저장
		userRepository.add(user);
		//가입이 완료되면 메세지를 출력
		System.out.println(user.getName() + "님 회원가입이 완료되었습니다.");
	}

	/**
	 * 로그인 기능
	 * @param id 아이디
	 * @param password 패스워드
	 * @return 로그인을 성공하면 ID반환, 실패시 ""반환
	 */
	@Override
	public String login(String id, String password) {
		//입력된 Id값으로 된 정보가 userRepository에 있는지 확인
		if (userRepository.find().containsKey(id)) {
			//일치하는 정보의 값을 받아 유저 객체에 넣음.
			User user = userRepository.find().get(id);
			//유저 객체에서 패스워드를 받아서 입력한 값과 일치하는지 확인
			if (user.getPassword().equals(password)) {
				//성공 시 메세지와 함께 입력한 id를 리턴
				System.out.println("로그인 성공!\n");
				return id;
				//패스워드가 일치하지 않으면 메세지 출력
			} else {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 시도해주세요.\n");
			}
		//패스워드가 일치하지 않으면 메세지 출력
		} else {
			System.out.println("ID가 존재하지 않습니다. 다시 시도해주세요.\n");
		}
		return "";//

	}

	/**
	 * 아이디 찾기 기능(성공: 아이디 출력, 실패: 오류 메세지 출력)
	 * @param userName 유저 이름
	 * @param userPhoneNumber 유저 휴대폰 번호
	 */
	public void findId(String userName, String userPhoneNumber) {
		//조건문에 찾기 성공여부를 넣을 boolean 타입의 변수 선언

		boolean found = false;
		for (User user : userRepository.find().values()) {
			if (user.getName().equals(userName) && user.getPhoneNumber().equals(userPhoneNumber)) {
				System.out.println("아이디는: " + user.getId() + " 입니다.");
				found = true;
				break;
			}if (!found) {
				System.out.println("등록된 아이디가 아닙니다. 다시 확인해주십시오.");
				break;
			}
		}
	}


	/**
	 * 패스워드 찾기 기능(성공: 패스워드 출력, 실패: 오류 메세지 출력)
	 * @param userId 유저 ID
	 * @param userName 유저 이름
	 * @param phoneNumber 유저 휴대폰 번호
	 */
	@Override
	public void findPw(String userId, String userName, String phoneNumber) {
		if (userRepository.find().containsKey(userId)) {
			User user = userRepository.find().get(userId);
			if (user.getName().equals(userName) && user.getPhoneNumber().equals(phoneNumber)) {
				System.out.println("패스워드는: " + user.getPassword() + " 입니다.");
			} else {
				System.out.println("아이디와 일치하는 정보가 존재하지 않습니다.");
			}
		} else System.out.println("입력하신 아이디가 존재하지 않습니다.");
	}

		/**
		 * 오렌지 마켓 메인페이지 출력 기능
		 */
		public void printMainPage() {
			System.out.println("===============================================");
			System.out.println("          Orange Market에 오신걸 환영합니다.          ");
			System.out.println("===============================================");
			System.out.println("                  ___");
			System.out.println("                _/o o\\_");
			System.out.println("               /_\\ - /_\\     Welcome!    ");
			System.out.println("                __|_|__     ________");
			System.out.println("               /       \\     |__|");
			System.out.println("              / /  |  \\ \\  / /");
			System.out.println("             /_/\\     /\\_\\/ /");
			System.out.println("===============================================");
		}

		/**
		 * 오렌지 마켓 로그인메뉴 출력 기능
		 */
		public void printLoginMenu() {
			System.out.println("===============================================");
			System.out.println("                    Login                 ");
			System.out.println("              -----------------                 ");
			System.out.println("              1. 로그인                           ");
			System.out.println("              2. 회원가입                          ");
			System.out.println("              3. 아이디 찾기                        ");
			System.out.println("              4. 패스워드 찾기                       ");
			System.out.println("              5. 종료                             ");
			System.out.println("===============================================");
			System.out.println("           원하시는 서비스 번호를 입력해주세요.            ");
		}

		/**
		 * 로그인 성공 후 메인메뉴 화면 출력 기능
		 */
		public void printMainMenu() {
			System.out.println("===============================================");
			System.out.println("                Main Service                 ");
			System.out.println("              -----------------                 ");
			System.out.println("              1. 상품등록                          ");
			System.out.println("              2. 상품 전체조회                       ");
			System.out.println("              3. 상품검색                           ");
			System.out.println("              4. 마이페이지                          ");
			System.out.println("              0. 종료                             ");
			System.out.println("===============================================");
			System.out.println("           원하시는 서비스 번호를 입력해주세요.            ");
		}
	}
