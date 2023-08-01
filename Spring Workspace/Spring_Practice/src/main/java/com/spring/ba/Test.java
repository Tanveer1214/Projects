package com.spring.ba;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/ba/config.xml");
		A a = context.getBean("proxy",A.class);
		a.m();
	}

}
