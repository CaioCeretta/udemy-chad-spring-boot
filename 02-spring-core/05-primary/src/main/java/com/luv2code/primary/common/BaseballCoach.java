package com.luv2code.primary.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    @Primary
    @Override
    public String getDailyWorkout() {
        return "Try to hit five home runs!";
    }
}
