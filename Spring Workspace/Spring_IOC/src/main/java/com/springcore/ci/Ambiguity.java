package com.springcore.ci;

public class Ambiguity {
	
	private int a;
	private int b;
	
	public Ambiguity(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("Constructor(int, int)");
	}
	
	public Ambiguity(double a, double b) {
		this.a = (int) a;
		this.b = (int) b;
		System.out.println("Constructor(double, double)");
	}
	
	public Ambiguity(String a, String b) {
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
		System.out.println("Constructor(String, String)");
	}
	
	public void sum() {
		System.out.println("Sum is "+(this.a + this.b));
	}

}
