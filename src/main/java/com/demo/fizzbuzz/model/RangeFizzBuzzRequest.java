package com.demo.fizzbuzz.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RangeFizzBuzzRequest {
  @ApiModelProperty(
      value = "Enter a number to get fizz buzz for the range starting with 1 till N(rangeN)",
      example = "100",
      required = true)
  private Integer rangeN;
}
