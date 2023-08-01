package com.springcore.stereo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/stereo/stereoconfig.xml");
		Country country = (Country) context.getBean("obj");
		System.out.println(country.getCities());
		
		/*
		// Bean Scope
		// 1: SingleTon
		System.out.println(country.hashCode());
		//it will not create other object it will return same object every time this is called singleton. 
		Country country2 = (Country) context.getBean("obj"); 
		System.out.println(country2.hashCode());
		
		// 2: Prototype
		// for prototype we will use Scope("prototype") annotation above class name.
		// also we can define scope in xml file
		Pro p1 = context.getBean("pro",Pro.class);
		Pro p2 = context.getBean("pro",Pro.class);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		*/
		
	}

}
