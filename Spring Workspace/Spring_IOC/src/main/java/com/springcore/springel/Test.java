package com.springcore.springel;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/springel/spelconfig.xml");
		Demo demo = context.getBean("demo",Demo.class);
		System.out.println(demo);
	}

}
