package com.demo.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.demo.fizzbuzz.exception.BadRequestException;
import com.demo.fizzbuzz.model.RangeFizzBuzzRequest;
import com.demo.fizzbuzz.model.SingleFizzBuzzRequest;
import com.demo.fizzbuzz.service.FizzBuzzService;
import com.demo.fizzbuzz.service.FizzBuzzServiceImpl;
import org.junit.jupiter.api.Test;

class FizzBuzzServiceUnitTests {

  private final FizzBuzzService service = new FizzBuzzServiceImpl();

  @Test
  public void testSingleResultForFizzOutput() {
    var result = service.getFizzBuzzForSingleNumber(new SingleFizzBuzzRequest(3));
    assertEquals("Fizz", result);
  }

  @Test
  public void testSingleResultForBuzzOutput() {
    var result = service.getFizzBuzzForSingleNumber(new SingleFizzBuzzRequest(5));
    assertEquals("Buzz", result);
  }

  @Test
  public void testSingleResultForFizzBuzzOutput() {
    var result = service.getFizzBuzzForSingleNumber(new SingleFizzBuzzRequest(30));
    assertEquals("Fizz Buzz", result);
  }

  @Test
  public void testRangeFizzBuzzResult() {
    var expectedResult = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz";
    var result = service.getFizzBuzzForRangeN(new RangeFizzBuzzRequest(15));
    assertEquals(expectedResult, result);
  }

  @Test
  public void testIncorrectInputForSingleResult() {
    assertThrows(
        BadRequestException.class,
        () -> service.getFizzBuzzForSingleNumber(new SingleFizzBuzzRequest(-1)));
  }

  @Test
  public void testIncorrectInputForRangeResult() {
    assertThrows(
        BadRequestException.class,
        () -> service.getFizzBuzzForRangeN(new RangeFizzBuzzRequest(-1)));
  }
}
