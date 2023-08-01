package com.springcore.ci;

public class Person {
	
	private int id;
	private String name;
    private Age age;
	
	public Person(int id, String name, Age age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "," + age + "]";
	}

}
