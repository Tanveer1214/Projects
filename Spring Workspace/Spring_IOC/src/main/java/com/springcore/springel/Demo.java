package com.springcore.springel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	@Value("#{10+30}")
	private int a;
	@Value("#{40+50}")
	private int b;
	@Value("#{T(java.lang.Math).sqrt(20)}")
	private int c;
	@Value("#{new java.lang.String('Tanveer')}")
	private String name;
	@Value("#{26 < 30}")
	private boolean isAlive;
	
	public Demo(String name) {
		this.name = name;
	}
	
	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public int getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Demo [a=" + a + ", b=" + b + ", c=" + c + ", name=" + name + ", isAlive=" + isAlive + "]";
	}
	
}
