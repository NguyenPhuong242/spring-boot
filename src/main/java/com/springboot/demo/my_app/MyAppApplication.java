package com.springboot.demo.my_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

// This annotation is a combination of the following annotations:
// - scanBasePackages: to specify the base packages to scan for annotated components and input beans
//@SpringBootApplication(
//		scanBasePackages = "com.springboot.demo"
//)

// SpringBootApplication
@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.demo")
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("CommandLineRunner running in the My App Application...");
		};
	}

}
