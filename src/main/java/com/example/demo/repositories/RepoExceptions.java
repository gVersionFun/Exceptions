package com.example.demo.repositories;

import com.example.demo.exceptions.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.ConnectException;

    @RestControllerAdvice
    public class RepoExceptions {

        @ExceptionHandler(ConnectException.class)
        protected ResponseEntity<ErrorDTO> handleValidationExceptions(ConnectException e) {
            ErrorDTO error = new ErrorDTO();
            error.setName(e.getClass().getSimpleName());
            error.setMessage(e.getMessage());

            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


