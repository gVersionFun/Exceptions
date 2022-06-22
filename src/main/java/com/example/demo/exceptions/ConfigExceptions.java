package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.ConstraintViolationException;
import java.util.Objects;

@RestControllerAdvice
public class ConfigExceptions{

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<StatusCode> handlerException(ResponseStatusException responseStatusException){
        StatusCode statusCode= new StatusCode(responseStatusException.getStatus().value(), responseStatusException.getReason());
        return new ResponseEntity<>(statusCode, responseStatusException.getStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO();
        error.setName("HttpMessageNotReadableException");
        error.setMessage(e.getMessage());

        if (e.getCause().getMessage().contains("grupo2DesadioSpring.App.flight.dtos.PayloadRequestDtoReservationFlight[\"seats\"]")) {
            error.setMessage("La cantidad de personas debe ser un valor númerico");
        }

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("MethodArgumentNotValidException");
        errorDTO.setMessage(Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> handleConstraintViolationException(ConstraintViolationException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("ConstraintViolationException");
        errorDTO.setMessage(ex.getLocalizedMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("MethodArgumentTypeMismatchException");
        errorDTO.setMessage("Formato de fecha debe ser dd/mm/aaaa");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ErrorDTO> handleIllegalAccessException(IllegalAccessException e) {
        ErrorDTO errorDTO = new ErrorDTO("IllegalAccessException", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}

