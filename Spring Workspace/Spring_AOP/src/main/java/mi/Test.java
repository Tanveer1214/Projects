package com.spring.mi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/mi/config.xml");
		A a = context.getBean("proxy",A.class);
		a.m();
	}

}
