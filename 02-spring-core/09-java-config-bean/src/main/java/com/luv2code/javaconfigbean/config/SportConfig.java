package com.luv2code.javaconfigbean.config;

import com.luv2code.javaconfigbean.common.Coach;
import com.luv2code.javaconfigbean.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }


}
