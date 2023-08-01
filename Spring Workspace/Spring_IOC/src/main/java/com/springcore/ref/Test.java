package com.springcore.ref;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ref/refconfig.xml");
		A obj = (A) context.getBean("R3");
		System.out.println(obj.getX());
		System.out.println(obj.getObj().getY());
		System.out.println(obj);
	}

}
