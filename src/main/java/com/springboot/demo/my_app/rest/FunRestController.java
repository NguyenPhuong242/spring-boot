package com.springboot.demo.my_app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

        //  inject properties for: coach.name and team.name
        @Value("${coach.name}")
        private String coachName;

        @Value("${team.name}")
        private String teamName;

        // expose new endpoint for "teaminfo"
        @GetMapping("/teaminfo")
        public String getTeamInfo() {
            return "Coach: " + coachName + ", Team name: " + teamName;
        }

        // expose "/" that return the spring info
        @GetMapping("/")
        public String info() {
            return "Hello World Time on server is: " + java.time.LocalDateTime.now();
        }

        // expose "/" that return "Hello World"
        @GetMapping("/index")
        public String sayHello() {
            return "Hello World!";
        }

        // expose a new endpoint for "workout"
        @GetMapping("/workout")
        public String getDailyWorkout() {
            return "Run a hard 5k!";
        }
}
