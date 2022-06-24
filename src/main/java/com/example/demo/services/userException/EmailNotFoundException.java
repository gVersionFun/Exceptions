package com.example.demo.services.userException;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String email_incorrecto) {
        super(email_incorrecto);
    }
}
