package com.springcore.javaconfig;


public class Person {
	
	private Student student;
	
	public Person(Student student) {
		super();
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String printMessage() {
		return "Good Morning, "+this.student.getMessage();
	}

}
