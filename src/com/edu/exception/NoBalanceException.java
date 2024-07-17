package com.edu.exception;

/**
 * 상품을 구매할 때 잔액이 부족할 시 예외발생하면 예외처리
 */
public class NoBalanceException extends RuntimeException{
    /**
     * 생성자1
     */
    public NoBalanceException() {
        super();
    }

    /**
     * 생성자2
     * @param message 예외 메세지를 전달받아 출력
     */
    public NoBalanceException(String message) {
        super(message);
    }
}
