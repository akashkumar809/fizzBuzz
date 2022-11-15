package com.demo.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import com.demo.fizzbuzz.controller.FizzBuzzController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FizzBuzzApplicationTests {
  @Autowired private FizzBuzzController controller;

  @Test
  void contextLoads() {
    assertThat(controller).isNotNull();
  }
}
