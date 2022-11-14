package com.demo.fizzbuzz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FizzBuzzExceptionController {

  @ExceptionHandler(value = BadRequestException.class)
  public ResponseEntity<String> exception(BadRequestException exception) {
    return new ResponseEntity<>(
        "The entered number or range should be positive integer value", HttpStatus.BAD_REQUEST);
  }
}
