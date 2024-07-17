package com.edu.service;

import java.util.*;

import com.edu.exception.NoBalanceException;
import com.edu.repository.ProductRepository;
import com.edu.repository.UserRepository;
import com.edu.vo.Product;
import com.edu.vo.User;

/**
 * ProductService 인터페이스의 구현 클래스입니다.
 * 상품 서비스 기능을 제공합니다.
 */
public class ProductServiceImpl implements ProductService {
	/**
	 * ProductRepository의 싱글톤 인스턴스를 생성합니다.
	 */
	private static final ProductRepository productRepository = ProductRepository.getInstance();
	/**
	 * ProductServiceImpl 클래스의 유일한 인스턴스를 생성합니다.
	 */
	private static final ProductServiceImpl productService = new ProductServiceImpl();
	/**
	 * UserRepository의 싱글톤 인스턴스를 생성합니다.
	 */
	private static final UserRepository userRepository = UserRepository.getInstance();
	/**
	 * UserServiceImpl의 싱글톤 인스턴스를 생성합니다.
	 */
	private static final UserServiceImpl userService = UserServiceImpl.getInstance();
	/**
	 * 로그인한 유저 필드를 선언합니다.
	 */
	private String userId;

	/**
	 * ProductServiceImpl의 기본 생성자.
	 * <p>
	 * 생성자를 private으로 지정하여 외부에서 새로운 인스턴스를 생성하지 못하도록 합니다.
	 * </p>
	 */
	private ProductServiceImpl() { }

	/**
	 * ProductServiceImpl의 유일한 인스턴스를 반환합니다.
	 * <p>
	 * 이 메서드는 싱글톤 패턴을 구현하며, 항상 동일한 인스턴스를 반환합니다.
	 * </p>
	 *
	 * @return ProductServiceImpl의 유일한 인스턴스
	 */
	public static ProductServiceImpl getInstance() {
		return productService;
	}

	/**
	 * 로그인한 유저의 아이디를 주입합니다.
	 * @param userId 로그인한 유저의 아이디
	 */
	public void setUser(String userId) {
		this.userId = userId;
	}

	/**
	 * !!!!!!!!!!!!!!!!삭제여부확인하세요
	 * @return
	 */
	public String userInfo() { //테스트용 메소드...
		User user = userRepository.find(userId);
		return "현재 ProductService 에 로그인 되어있는 유저의 정보입니다 : " + user.toString();
	}

	/**
	 * 숫자로 받은 유저의 주소를 문자열로 반환하는 기능
	 * @param addressNumber 주소 선택 옵션
	 * @return 전달받은 addressNumber조건 일치여부에 따라 값을 반환
	 */
	private String addressIntToString(int addressNumber) {
		switch (addressNumber) {
			case 1:
				return "서울";
			case 2:
				return "인천";
			case 3:
				return "경기도";
		}
		return "";
	}

	/**
	 * 반복되어 돌아가는 코드 정의
	 * 전달받은 상품목록을 가공하고 출력해주는 기능
	 * @param products 주입 받은 상품의 목록
	 */
	private void viewProductInfo(Map<Integer, Product> products) {
		for (int key : products.keySet()) {
			String name = products.get(key).getName();
			int price = products.get(key).getPrice();
			String sellerName = products.get(key).getUser().getName();
			String sellerAddress = products.get(key).getUser().getAddress();

			System.out.println("[" + key + "]" + " 상품명: " + name + ", 가격: " + price + "원, 판매자: " + sellerName + ", 지역: " + sellerAddress);
		}
	}
	/**
	 * 반복되어 돌아가는 코드 정의
	 * 전달받은 상품목록을 가공하고 출력해주는 기능
	 * @param productList 주입 받은 상품의 목록
	 */
	private void printProductList(Map<Integer, Product> productList) {
		for (Integer i : productList.keySet()) {
			Product product = productList.get(i);
			System.out.println("["+i+"]"+ " 상품명: " + product.getName() + ", 가격: " + product.getPrice() + ", 상세정보: " + product.getInfo() + ", 카테고리: " + product.getCategory());
		}
	}

	/**
	 *상품 전체조회 기능
	 */
	public void viewAllProduct() {
		Map<Integer, Product> temp = new HashMap<>();
		Map<Integer, Product> productsList = productRepository.find();
		for (Integer i : productsList.keySet())
			temp.put(i, productsList.get(i));

		// 목록출력
		if(temp.isEmpty()) {
			System.out.println("목록이 없습니다.");
		}else{
			printProductList(temp);
		}
	}

	/**
	 *상품 상세조회 기능
	 * @param productKey 상품번호
	 */
	public void viewProductDetail(int productKey) {
		Product product = productRepository.find(productKey);

		System.out.println("\n======== 번호: " + productKey + " 의 상품 정보입니다. ========");
		System.out.println("상품 이름: " +product.getName());
		System.out.println("상품 가격:" + product.getPrice());
		System.out.println("상품 카테고리: " + product.getCategory());
		System.out.println("상품 정보: " + product.getInfo());
		System.out.println("상품 등록자: " + product.getUser());

		//현재 로그인한 사용자의 물건이라면...
		if (userId.equals(product.getUser().getId())) System.out.println("(1) 수정하기, (2) 삭제하기, (0) 뒤로가기");
		else System.out.println("(1) 구매하기, (0) 뒤로가기");
	}

	/**
	 * 내가 등록한 상품을 조회하는 기능
	 */
	public void myProduct() {
		System.out.println("\n===================== 내가 등록한 상품들 =====================");
		Map<Integer, Product> productMap = productRepository.find(userId);

		viewProductInfo(productMap);
	}

	/**
	 * 상품명을 텍스트로 검색하는 기능
	 * @param name 상품명
	 */
	public void findProductByName(String name) {
		Map<Integer, Product> temp = new HashMap<>();
		Map<Integer, Product> productsList = productRepository.find();
		// 검색한 상품에 대한 목록
		for (Integer i : productsList.keySet())
			if(productsList.get(i).getName().contains(name))
				temp.put(i, productsList.get(i));
		// 목록 출력
		if(temp.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		}else{
			printProductList(temp);
		}
	}

	/**
	 * 상품의 카테고리를 선택하여 검색하는 기능
	 * @param category 상품의 카테고리
	 */
	public void findProductByCategory(String category) {
		Map<Integer, Product> temp = new HashMap<>();
		Map<Integer, Product> productsList = productRepository.find();
		for (Integer i : productsList.keySet()) {
			if(productsList.get(i).getCategory().equals(category)){
				temp.put(i, productsList.get(i));
			}
		}
		// 목록 출력
		if(temp.isEmpty()) {
			System.out.println("카테고리 검색 결과가 없습니다.");
		}else{
			printProductList(temp);
		}
	}

	/**
	 * 상품을 구매하는 기능
	 * @param productKey 상품번호
	 * @throws NoBalanceException 상품을 구매할 때 잔액이 부족할 시 예외발생하면 예외처리
	 */
	public void buyProduct(int productKey) throws NoBalanceException {

		//현재 로그인한(구매하려는) 유저의 정보 가져오기
		User user = userRepository.find(userId);

		//구매하려는 상품 정보 가져오기
		Product product = productRepository.find(productKey);

		//판매자 정보 가져오기
		User seller = product.getUser();

		// 물건 금액만큼 구매자 포인트 차감
		System.out.println("\n====================구매 진행=======================");
		int point = user.getPoint() - product.getPrice(); //현재 잔액 - 구매하려는 상품의 가격

		//사용자 정의 에러 사용 (NoBalanceException)
		if (point < 0) { //잔액이 부족 하면 예외를 던진다.
			throw new NoBalanceException("[거래 실패] 잔액 부족입니다. 충전 후 이용해주세요^^");
		} else {
			//현재 구매한 유저의 잔액을 변경 (기존 잔액 - 상품 가격)
			user.setPoint(point);

			// 물건 금액만큼 판매자 포인트 증가
			int sellerPoint = seller.getPoint() + product.getPrice();

			//판매자의 잔액을 수정(증가)
			userService.chargePoint(seller, sellerPoint);

			System.out.println(user.getName() + "님이 [상품번호"+productKey+"]" + product.getName() + "을 구매하셨습니다.");
			System.out.println(user.getName() + "님의 남은 잔액은 : " + user.getPoint() + "원 입니다.");

			System.out.println("====================구매 완료=======================");

			//구매 완료 후 해당 상품 삭제
			productRepository.delete(productKey);
		}
	}
}
