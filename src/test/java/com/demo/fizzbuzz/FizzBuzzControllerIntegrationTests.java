package com.demo.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzControllerIntegrationTests {
  private static final String SINGLE_FIZZBUZZ_RESULT_PATH = "/fizzbuzz/single";
  private static final String RANGE_FIZZBUZZ_RESULT_PATH = "/fizzbuzz/range";
  private static final String SINGLE_RESULT_QUERY_PARAM = "number";
  private static final String RANGE_RESULT_QUERY_PARAM = "rangeN";

  @LocalServerPort private int port;
  @Autowired private TestRestTemplate restTemplate;

  @Test
  public void testSingleFizzBuzzResultForFizzOutput() {
    var response = fetchResponseFromApi(SINGLE_FIZZBUZZ_RESULT_PATH, SINGLE_RESULT_QUERY_PARAM, 3);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Fizz", response.getBody());
  }

  @Test
  public void testSingleFizzBuzzResultForBuzzOutput() {
    var response = fetchResponseFromApi(SINGLE_FIZZBUZZ_RESULT_PATH, SINGLE_RESULT_QUERY_PARAM, 5);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Buzz", response.getBody());
  }

  @Test
  public void testSingleFizzBuzzResultForFizzBuzzOutput() {
    var response = fetchResponseFromApi(SINGLE_FIZZBUZZ_RESULT_PATH, SINGLE_RESULT_QUERY_PARAM, 15);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Fizz Buzz", response.getBody());
  }

  @Test
  public void testSingleFizzBuzzResultForNumberOutput() {
    var response = fetchResponseFromApi(SINGLE_FIZZBUZZ_RESULT_PATH, SINGLE_RESULT_QUERY_PARAM, 7);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("7", response.getBody());
  }

  @Test
  public void testRangeFizzBuzzResult() {
    var expectedResult = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz";
    var response = fetchResponseFromApi(RANGE_FIZZBUZZ_RESULT_PATH, RANGE_RESULT_QUERY_PARAM, 15);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(expectedResult, response.getBody());
  }

  @Test
  public void testIncorrectInputForSingleFizzBuzzResult() {
    var response = fetchResponseFromApi(SINGLE_FIZZBUZZ_RESULT_PATH, SINGLE_RESULT_QUERY_PARAM, -7);
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertEquals(
        "The entered number or range should be positive integer value", response.getBody());
  }

  private ResponseEntity<String> fetchResponseFromApi(String path, String param, int paramValue) {
    String url =
        UriComponentsBuilder.fromHttpUrl("http://localhost")
            .port(port)
            .path(path)
            .queryParam(param, String.valueOf(paramValue))
            .toUriString();
    HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());
    return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
  }
}
