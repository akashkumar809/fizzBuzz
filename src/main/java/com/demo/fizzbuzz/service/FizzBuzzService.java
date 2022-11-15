package com.demo.fizzbuzz.service;

import com.demo.fizzbuzz.model.RangeFizzBuzzRequest;
import com.demo.fizzbuzz.model.SingleFizzBuzzRequest;

public interface FizzBuzzService {

  String getFizzBuzzForSingleNumber(final SingleFizzBuzzRequest request);

  String getFizzBuzzForRangeN(final RangeFizzBuzzRequest request);
}
