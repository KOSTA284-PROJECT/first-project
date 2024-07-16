package com.edu.exception;

public class NoBalanceException extends RuntimeException{
    public NoBalanceException() {
        super();
    }

    public NoBalanceException(String message) {
        super(message);
    }
}
