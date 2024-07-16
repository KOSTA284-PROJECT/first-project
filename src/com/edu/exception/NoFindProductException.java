package com.edu.exception;

public class NoFindProductException extends RuntimeException {
    public NoFindProductException() {
    }

    public NoFindProductException(String message) {
        super(message);
    }
}
