package com.demo.fizzbuzz.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FizzBuzzExceptionController {

  @ExceptionHandler(value = BadRequestException.class)
  public ResponseEntity<String> exception(BadRequestException exception) {
    return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
  }
}
