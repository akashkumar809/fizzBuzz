package com.demo.fizzbuzz.controller;

import com.demo.fizzbuzz.model.RangeFizzBuzzRequest;
import com.demo.fizzbuzz.model.SingleFizzBuzzRequest;
import com.demo.fizzbuzz.service.FizzBuzzService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {

  @Autowired private FizzBuzzService service;

  @ApiOperation(value = "Get the fizzBuzz result for a single number")
  @RequestMapping(
      value = "/single",
      method = RequestMethod.GET,
      produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> getFizzBuzzForSingleNumber(
      @RequestBody SingleFizzBuzzRequest request) {
    log.info(
        "[/FizzBuzzController][/getFizzBuzzForSingleNumber] - get fizz buzz result for single number");
    return new ResponseEntity<>(service.getFizzBuzzForSingleNumber(request), HttpStatus.OK);
  }

  @ApiOperation(value = "Get the fizzBuzz result for a range of numbers")
  @RequestMapping(
      value = "/range",
      method = RequestMethod.GET,
      produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> getFizzBuzzForRangeOfNumber(
      @RequestBody RangeFizzBuzzRequest request) {
    log.info(
        "[/FizzBuzzController][/getFizzBuzzForRangeOfNumber] - get fizz buzz result for range of number");
    return new ResponseEntity<>(service.getFizzBuzzForRangeN(request), HttpStatus.OK);
  }
}
