package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.io.FileNotFoundException;
import java.io.IOException;


@RestControllerAdvice
public class ConfigExceptions {

    //Bean validations
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO();
        error.setName(e.getClass().getSimpleName());
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler (FileNotFoundException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(FileNotFoundException e) {
        ErrorDTO error = new ErrorDTO();
        error.setName(e.getClass().getSimpleName());
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (IOException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(IOException e) {
        ErrorDTO error = new ErrorDTO();
        error.setName(e.getClass().getSimpleName());
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }






}

