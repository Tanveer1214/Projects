package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	
	@Bean
	public Student getStudent() {
		return new Student();
	}
	
	@Bean(name = {"temp","student","tani"}) // bean names you can anyone of them
	public Person getPerson() {
		return new Person(getStudent());
	}

}
