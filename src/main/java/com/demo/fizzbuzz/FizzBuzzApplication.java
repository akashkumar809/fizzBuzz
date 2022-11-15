package com.demo.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.demo.fizzbuzz"})
public class FizzBuzzApplication {

  public static void main(String[] args) {
    SpringApplication.run(FizzBuzzApplication.class, args);
  }
}
