package com.springcore.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//		Student student = context.getBean("student",Student.class);
//		System.out.println(student.getMessage());
//		System.out.println(student.n);
//		System.out.println(student.s);
//		System.out.println(student.b);
		
		Person person = context.getBean("tani",Person.class);
		System.out.print(person.printMessage());
		
	}

}
