package com.springboot.demo.my_app.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WorkerRestExceptionHandler {
    // Add an exception handler using @ExceptionHandler
    // Add an exception handler for WorkerNotFoundException
    // Add another exception handler ... to catch any exception (catch all)

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<WorkerErrorResponse> handleException(WorkerNotFoundException exc) {
        // create WorkerErrorResponse
        WorkerErrorResponse error = new WorkerErrorResponse();
        // set status and message
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<WorkerErrorResponse> handleException(Exception exc) {
        // create WorkerErrorResponse
        WorkerErrorResponse error = new WorkerErrorResponse();
        // set status and message
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
