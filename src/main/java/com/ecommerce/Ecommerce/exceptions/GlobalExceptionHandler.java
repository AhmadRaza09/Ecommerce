package com.ecommerce.Ecommerce.exceptions;

import com.ecommerce.Ecommerce.response.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        log.error("MethodArgumentNotValidException: exception {} ", methodArgumentNotValidException);
        ApiResponse<Object> apiResponse = ApiResponse.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), methodArgumentNotValidException.getMessage(), null, errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException constraintViolationException) {
        Map<String, String> errors = new HashMap<>();

        for (ConstraintViolation violationException : constraintViolationException.getConstraintViolations()) {
            errors.put(violationException.getPropertyPath().toString(), violationException.getMessage());
        }

        log.error("ConstraintViolationException:  exception {} " + constraintViolationException);
        ApiResponse<Object> apiResponse = ApiResponse.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), constraintViolationException.getMessage(), null, errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("exception", exception.getMessage());

        log.error("Exception:  exception {} ", exception);
        ApiResponse<Object> apiResponse = ApiResponse.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), null, errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
