package com.springboot.demo.my_app.rest;

import com.springboot.demo.my_app.entity.Worker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkerRestController {
    // define endpoint for "/workers"
    // return list of workers
    // http://localhost:1208/my-app/api/workers
    @GetMapping("/workers")
    public List<Worker> getWorkers() {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("John", 30));
        workers.add(new Worker("Mike", 25));
        workers.add(new Worker("Tom", 35));
        return workers;
    }
}
