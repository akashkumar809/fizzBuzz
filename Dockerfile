FROM openjdk:17
ADD target/fizzBuzz-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
