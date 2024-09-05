package com.springboot.demo.my_app.common;

import org.springframework.stereotype.Component;

public class ConfigCoach implements Coach{

        @Override
        public String getDailyWorkout() {
            return "Hello dude!";
        }

        public ConfigCoach() {
//            System.out.println("ConfigCoach: inside the default constructor" + getClass().getSimpleName());
        }
}
