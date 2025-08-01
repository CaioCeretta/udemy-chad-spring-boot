package com.luv2code.springboot.demo.devtools.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Expose "/" endpoint that returns "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }


    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }

}
