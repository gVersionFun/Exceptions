package com.example.demo.services.userException;

public class SendToQueueException extends RuntimeException {
    public SendToQueueException(String s) {
        super(s);
    }
}
