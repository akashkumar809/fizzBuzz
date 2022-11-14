package com.demo.fizzbuzz.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingleFizzBuzzRequest {

  @ApiModelProperty(value = "Enter a number to check Fizz Buzz", example = "15", required = true)
  private Integer number;
}
