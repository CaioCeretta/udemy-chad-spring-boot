package com.luv2code.scopes.rest;

import com.luv2code.scopes.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    public DemoController(
            @Qualifier("baseballCoach") Coach theCoach,
            @Qualifier("baseballCoach") Coach theOtherCoach) {
        System.out.println("In constructor " + getClass().getSimpleName());
        // Initially, all these reference the same baseballCoach bean
        myCoach = theCoach;
        anotherCoach = theOtherCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    // Check to see if they use the same bean
    @GetMapping("/check")
    public String check() {
        return "Compared beans: myCoach == anotherCoach: " + (myCoach == anotherCoach);
    }
}