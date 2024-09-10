package com.springboot.demo.my_app.rest;

import com.springboot.demo.my_app.entity.Worker;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkerRestController {

    private List<Worker> workers;
    // define @PostConstruct to load the worker data only once

    @PostConstruct
    public void loadData() {
        workers = new ArrayList<>();
        workers.add(new Worker("John", 30));
        workers.add(new Worker("Mike", 25));
        workers.add(new Worker("Tom", 35));
    }

    // define endpoint for "/workers"
    // return list of workers
    // http://localhost:1208/my-app/api/workers
    @GetMapping("/workers")
    public List<Worker> getWorkers() {
        return workers;
    }

    // define endpoint for "/workers/workerId"
    // return worker at index
    // http://localhost:1208/my-app/api/workers/1
    @GetMapping("/workers/{workerId}")
    public Worker getWorker(@PathVariable int workerId) {

        // check the workerId against list size
        if (workerId >= workers.size() || workerId < 0) {
            throw new WorkerNotFoundException("Worker id not found - " + workerId);
        }
        return workers.get(workerId);
    }


}
