package com.springboot.demo.my_app.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy use for the lazy initialization
//@Primary use for the main class for the dependency injection
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) use for the prototype scope of the bean. Example: theCoach == anotherCoach: false because theCoach and anotherCoach are different instances
public class BoyCoach implements Coach{

//    // define init method
//    @PostConstruct
//    public void doMyStartupStuff() {
//        System.out.println("BoyCoach: inside of doMyStartupStuff()" + getClass().getSimpleName());
//    }
//
//    // define destroy method
//    @PreDestroy
//    public void doMyCleanupStuff() {
//        System.out.println("BoyCoach: inside of doMyCleanupStuff()" + getClass().getSimpleName());
//    }



    @Override
    public String getDailyWorkout() {
        return "Hello";
    }

    public BoyCoach() {
//        System.out.println("BoyCoach: inside the default constructor" + getClass().getSimpleName());
    }
}
