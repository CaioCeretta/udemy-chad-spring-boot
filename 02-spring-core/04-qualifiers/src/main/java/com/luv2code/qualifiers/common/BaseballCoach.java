package com.luv2code.qualifiers.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Try to hit five home runs!";
    }
}
