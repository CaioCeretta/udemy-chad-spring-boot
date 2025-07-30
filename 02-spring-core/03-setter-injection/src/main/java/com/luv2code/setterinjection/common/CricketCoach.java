package com.luv2code.setterinjection.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Setter, Practice fast bowling for 15 minutes!";
    }
}
