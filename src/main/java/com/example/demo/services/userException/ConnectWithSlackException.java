package com.example.demo.services.userException;

public class ConnectWithSlackException extends RuntimeException {
    public ConnectWithSlackException(String error_de_conexión_con_slack) {
        super(error_de_conexión_con_slack);
    }
}
