package com.luv2code.javaconfigbean.common;

import org.springframework.stereotype.Component;

@Component
// By doing this, there will be a different bean for each injection
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Try to hit five home runs!";
    }
}
