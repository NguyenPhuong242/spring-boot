package com.springboot.demo.my_app.rest;

import com.springboot.demo.my_app.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TryController {
    // define a private field for the dependency
    private Coach theCoach;

//    private Coach anotherCoach;

    // define a constructor for dependency injection
    @Autowired
    public TryController(@Qualifier("configCoach") Coach theCoach) {
        this.theCoach = theCoach;
//        System.out.println("TryController: inside the constructor " + getClass().getSimpleName());
    }

    // Setter
    @Autowired
    public void setTheCoach(@Qualifier("configCoach") Coach theCoach) {;
        this.theCoach = theCoach;

    }
    // public void setTheCoach(@Qualifier("boyCoach") Coach theCoach) solution for the error: Field theCoach in com.springboot.demo.my_app.rest.TryController required a bean of type 'com.springboot.demo.my_app.common.Coach' that could not be found.
    // or use the Primary annotation in the BoyCoach class
    @GetMapping("/try")
    public String getDailyWorkout() {
        return theCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check(){
//        return "Comparing beans: theCoach == anotherCoach: " + (theCoach == anotherCoach);
//    }


}
