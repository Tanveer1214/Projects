package com.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/config.xml");
        Student st = (Student) context.getBean("temp3");
        System.out.println(st);
    }
}
