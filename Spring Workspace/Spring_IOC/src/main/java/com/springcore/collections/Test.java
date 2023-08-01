package com.springcore.collections;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public abstract class Test {

	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("com/springcore/collections/collectionconfig.xml");
		Person p = (Person) context.getBean("c1");
		System.out.println("Name: "+p.getName());
		System.out.println("Projects: "+p.getProjects());
		System.out.println("Addresses: "+p.getAddresses());
		System.out.println("Qulifications: "+p.getGrudation());
	}

}
