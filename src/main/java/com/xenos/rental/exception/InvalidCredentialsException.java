package com.xenos.rental.exception;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException() {
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }


    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
