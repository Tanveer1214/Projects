package com.springcore.ci;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ci/ciconfig.xml");
		Person p = (Person) context.getBean("con1");
		//System.out.println(p);
		Ambiguity ab = (Ambiguity) context.getBean("con3");
		ab.sum();
	}

}
