package com.example.demo.services.userException;
import com.example.demo.exceptions.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserException{

    @ExceptionHandler(SendToQueueException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(SendToQueueException e) {
        ErrorDTO error = new ErrorDTO();
        error.setName(e.getClass().getSimpleName());
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(EmailNotFoundException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(EmailNotFoundException e) {
        ErrorDTO error = new ErrorDTO();
        error.setName(e.getClass().getSimpleName());
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConnectWithSlackException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(ConnectWithSlackException e) {
        ErrorDTO error = new ErrorDTO();
        error.setName(e.getClass().getSimpleName());
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConnectEmailException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(ConnectEmailException e) {
        ErrorDTO error = new ErrorDTO();
        error.setName(e.getClass().getSimpleName());
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }







}

