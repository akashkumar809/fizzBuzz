# [Fizz Buzz Game](https://en.wikipedia.org/wiki/Fizz_buzz)

### Fizz Buzz game using spring-boot

The application has two endpoints
1. **/fizzbuzz/range** - Get the fizzBuzz result for a range of numbers
    * Input: **rangeN** (as query parameter) - range endpoint inclusive.
    * Output: String - comma seperated fizzBuzz game output starting from integer 1 till the rangeN(inclusive) provided as input. for example: rangeN is provided as 20, so the output would be ```1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz, 16, 17, Fizz, 19, Buzz```
2. **/fizzbuzz/single** - Get the fizzBuzz result for a single number
    * Input: **number** (as query parameter) - single number
    * Output: String - fizzBuzz game output for the single number provided as input. for example: number is provided as 15, so the output would be ``Fizz Buzz``.

