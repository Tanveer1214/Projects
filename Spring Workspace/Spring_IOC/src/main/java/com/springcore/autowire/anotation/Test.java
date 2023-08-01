package com.springcore.autowire.anotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/autowire/anotation/autowireanoconfig.xml");
		Student student = (Student) context.getBean("student1");
		System.out.println(student);
	}

}
