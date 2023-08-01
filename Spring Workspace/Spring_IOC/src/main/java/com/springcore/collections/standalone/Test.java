package com.springcore.collections.standalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/collections/standalone/standaloneconfig.xml");
		Temp temp = (Temp) context.getBean("rollnumbers");
		System.out.println(temp);
	}

}
