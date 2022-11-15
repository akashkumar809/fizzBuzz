package com.demo.fizzbuzz.exception;

import java.io.Serial;
import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
public class BadRequestException extends RuntimeException {
  @Serial private static final long serialVersionUID = 1L;
  HttpStatus status;

  public BadRequestException() {
    super("The entered number or range should be positive integer value");
    this.status = HttpStatus.BAD_REQUEST;
  }
}
