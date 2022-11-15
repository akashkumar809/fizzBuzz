package com.demo.fizzbuzz.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class FizzBuzzExceptionController {

  @ExceptionHandler(value = BadRequestException.class)
  public ResponseEntity<String> exception(BadRequestException exception) {
    log.error(exception.getMessage(), exception);
    return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
  }
}
