package com.harshtech.employee.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.harshtech.employee.management")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
