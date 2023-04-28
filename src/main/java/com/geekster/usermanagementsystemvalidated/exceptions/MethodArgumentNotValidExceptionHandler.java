package com.geekster.usermanagementsystemvalidated.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
       Map<String,String> resp = new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((error)->{
          String fieldName =  ((FieldError)error).getField();
          String defaultMessage = error.getDefaultMessage();
          resp.put(fieldName,defaultMessage);
       });
       return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
    }
}
