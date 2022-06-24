package com.example.demo.services.userException;

public class ConnectEmailException extends RuntimeException {
    public ConnectEmailException(String s) {
        super(s);
    }
}
