package com.edu.service;

import java.util.*;

import com.edu.exception.NoBalanceException;
import com.edu.exception.NoFindProductException;
import com.edu.repository.ProductRepository;
import com.edu.repository.UserRepository;
import com.edu.vo.Product;
import com.edu.vo.User;

public class ProductServiceImpl implements ProductService {

	// 싱글톤,,,
	private static final ProductRepository productRepository = ProductRepository.getInstance();
	private static final ProductServiceImpl productService = new ProductServiceImpl();
	private static final UserRepository userRepository = UserRepository.getInstance();
	private static final UserServiceImpl userService = UserServiceImpl.getInstance();

	private String userId;

	private ProductServiceImpl() { }

	public static ProductServiceImpl getInstance() {
		return productService;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String userInfo() { //테스트용 메소드...
		User user = userRepository.find(userId);
		return "현재 ProductService 에 로그인 되어있는 유저의 정보입니다 : " + user.toString();
	}

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

	//주입받은 상품 목록들의 정보 출력
	private void viewProductInfo(Map<Integer, Product> products) {
		for (int key : products.keySet()) {
			String name = products.get(key).getName();
			int price = products.get(key).getPrice();
			String sellerName = products.get(key).getUser().getName();
			String sellerAddress = products.get(key).getUser().getAddress();

			System.out.println("[" + key + "]" + " 상품명: " + name + ", 가격: " + price + "원, 판매자: " + sellerName + ", 지역: " + sellerAddress);
		}
	}

//	public void sort(Map<Integer, Product> products) {
//        List<Product> list = new ArrayList<>(products.values());
//
//		Collections.sort(list, (o1, o2) -> -(o1.getPrice() - o2.getPrice()));
//	}

	//상품 전체 조회()
	public void viewAllProduct() {
		System.out.println("\n===================== 등록된 상품들 =====================");
		Map<Integer, Product> productMap = productRepository.find();

		viewProductInfo(productMap);
	}

	//상품 상세 조회() -> 나
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
	
	//내가 등록한 상품 조회()
	public void myProduct() {
		System.out.println("\n===================== 내가 등록한 상품들 =====================");
		Map<Integer, Product> productMap = productRepository.find(userId);

		viewProductInfo(productMap);
	}

	//상품 텍스트 검색()
	public void findProductByName(String name) throws NoFindProductException {
		//등록된 상품 전체 가져오기
		Map<Integer, Product> productMap = productRepository.find();
		Map<Integer, Product> resultMap = new HashMap<>();

		for (Integer key : productMap.keySet()) {
			if (productMap.get(key).getName().contains(name))
				resultMap.put(key, productMap.get(key));
		}

		System.out.println("\n===================== 상품 텍스트 검색 결과 =====================");

		if (resultMap.isEmpty())
			throw new NoFindProductException("상품이 존재하지 않습니다.");

		viewProductInfo(resultMap);
	}
	
	//상품 카테고리 검색()
	public void findProductByCategory(int categoryNumber) {
		//등록된 상품 전체 가져오기
		Map<Integer, Product> productMap = productRepository.find();
		Map<Integer, Product> resultMap = new HashMap<>();
		String category = addressIntToString(categoryNumber);

		for (Integer key : productMap.keySet()) {
			if (productMap.get(key).getCategory().equals(category))
				resultMap.put(key, productMap.get(key));
		}

		System.out.println("\n===================== 상품 카테고리 검색 결과 =====================");
		viewProductInfo(resultMap);
	}

	//나중에 시간 되면 가격 범위로 상품 검색()....


	//상품 구매 -> 나
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
