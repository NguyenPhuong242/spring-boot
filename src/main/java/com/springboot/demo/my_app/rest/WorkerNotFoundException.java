package com.springboot.demo.my_app.rest;

public class WorkerNotFoundException extends RuntimeException{

        public WorkerNotFoundException(String message) {
            super(message);
        }

        public WorkerNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public WorkerNotFoundException(Throwable cause) {
            super(cause);
        }
}
