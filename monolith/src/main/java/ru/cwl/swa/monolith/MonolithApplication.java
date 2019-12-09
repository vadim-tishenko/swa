package ru.cwl.swa.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonolithApplication {
// https://howtodoinjava.com/spring-boot2/h2-database-example/
	public static void main(String[] args) {
		SpringApplication.run(MonolithApplication.class, args);
		System.out.println("http://localhost:8080/h2-console");
	}

}
