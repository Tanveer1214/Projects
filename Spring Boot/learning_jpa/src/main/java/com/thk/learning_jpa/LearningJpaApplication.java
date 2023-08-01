package com.thk.learning_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningJpaApplication {

	public static void main(String[] args) {
		System.out.println("Hey JPA");
		SpringApplication.run(LearningJpaApplication.class, args);
	}

}
