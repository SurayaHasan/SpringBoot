package com.suraya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringBootApplicationCounter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationCounter.class, args);
    }

    // All your code should be inside this one class
    // add @RestController to you expose methods as REST services to clients
    // create a variable static int count = 0;

    // All methods should have a @GetMapping
    // Create a method to get current count. i.e localhost:8080/current-count
    // int count =0 has to be outside of the main
    int count =0;

    @GetMapping(path = "current-count")
        //method 1
        int CurrentCount() {
        return count;
    }

    // Create method to increment the count. i.e localhost:8080/increment-count

    @GetMapping (path = "increment-count")
    // method 2
    int incrementCurrent(){
        //count++ = returns the value
        ++count;
        return count;
    }

    // Create method to decrement the count. i.e localhost:8080/decrement-count
    @GetMapping (path = "decrement-count")
    // method 2
    int decrementCurrent(){
        count--;
        return count;
    }
    // Test your api with chrome
}