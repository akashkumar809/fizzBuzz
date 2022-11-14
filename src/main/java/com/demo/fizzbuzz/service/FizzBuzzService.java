package com.demo.fizzbuzz.service;

import com.demo.fizzbuzz.exception.BadRequestException;
import com.demo.fizzbuzz.model.RangeFizzBuzzRequest;
import com.demo.fizzbuzz.model.SingleFizzBuzzRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FizzBuzzService {

  public ResponseEntity<String> getFizzBuzzForSingleNumber(final SingleFizzBuzzRequest request) {
    validateRequest(request.getNumber());
    return new ResponseEntity<>(fizzBuzzResult(request.getNumber()), HttpStatus.OK);
  }

  public ResponseEntity<String> getFizzBuzzForRangeN(final RangeFizzBuzzRequest request) {
    validateRequest(request.getRangeN());
    List<String> ranges =
        IntStream.range(1, request.getRangeN() + 1).mapToObj(this::fizzBuzzResult).toList();
    return new ResponseEntity<>(String.join(", ", ranges), HttpStatus.OK);
  }

  protected String fizzBuzzResult(int number) {
    if (number % 15 == 0) {
      return "Fizz Buzz";
    }
    if (number % 3 == 0) {
      return "Fizz";
    }
    if (number % 5 == 0) {
      return "Buzz";
    }
    return String.valueOf(number);
  }

  protected void validateRequest(final Integer number) {
    Optional.ofNullable(number).filter(num -> num > 0).orElseThrow(BadRequestException::new);
  }
}
