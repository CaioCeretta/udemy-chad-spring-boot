package com.luv2code.scopes.rest;

import com.luv2code.scopes.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private final Coach myCoach;

    public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
        System.out.println("In constructor " + getClass().getSimpleName());
        // Initially, all these reference the same baseballCoach bean
        myCoach = theCoach;
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff: " + getClass().getSimpleName());
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


}