package com.springcore.autowire;

public class Student {
	
	private int id;
	private String batch;
	private Person person;
	
	public Student(int id, String batch, Person person) {
		super();
		this.id = id;
		this.batch = batch;
		this.person = person;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", batch=" + batch + ", person=" + person + "]";
	}
	
}
