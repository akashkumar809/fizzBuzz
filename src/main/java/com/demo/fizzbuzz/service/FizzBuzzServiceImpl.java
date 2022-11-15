package com.demo.fizzbuzz.service;

import com.demo.fizzbuzz.exception.BadRequestException;
import com.demo.fizzbuzz.model.RangeFizzBuzzRequest;
import com.demo.fizzbuzz.model.SingleFizzBuzzRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FizzBuzzServiceImpl implements FizzBuzzService {
  @Override
  public String getFizzBuzzForSingleNumber(final SingleFizzBuzzRequest request) {
    validateRequest(request.getNumber());
    return fizzBuzzResult(request.getNumber());
  }

  @Override
  public String getFizzBuzzForRangeN(final RangeFizzBuzzRequest request) {
    validateRequest(request.getRangeN());
    List<String> ranges =
        IntStream.range(1, request.getRangeN() + 1).mapToObj(this::fizzBuzzResult).toList();
    return String.join(", ", ranges);
  }

  private String fizzBuzzResult(int number) {
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

  private void validateRequest(final Integer number) {
    Optional.ofNullable(number).filter(num -> num > 0).orElseThrow(BadRequestException::new);
  }
}
