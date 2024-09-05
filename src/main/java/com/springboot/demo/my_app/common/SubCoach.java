package com.springboot.demo.my_app.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// That's the implementation of the Coach interface
// This class will be scanned by Spring and registered as a bean
@Component
// @Lazy
// This @Lazy annotation is used to indicate that a bean should be lazily initialized.
public class SubCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Try to eat 5 fruits a day!";
    }

//    public SubCoach() {
//        System.out.println("SubCoach: inside the default constructor" + getClass().getSimpleName());
//    }
}
