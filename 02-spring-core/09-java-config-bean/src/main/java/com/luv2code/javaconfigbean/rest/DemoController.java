package com.luv2code.javaconfigbean.rest;

import com.luv2code.javaconfigbean.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private final Coach myCoach;

    public DemoController(@Qualifier("aquatic") Coach theCoach) {
        System.out.println("In constructor " + getClass().getSimpleName());
        // Initially, all these reference the same baseballCoach bean
        myCoach = theCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


}