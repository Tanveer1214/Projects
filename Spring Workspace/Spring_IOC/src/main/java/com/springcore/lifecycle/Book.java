package com.springcore.lifecycle;

public class Book {
	private int id;
	private String name;
	private String author;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	public void chalo() {
		System.out.println("Chaliye shroo karte hen");
	}
	
	public void khatam() {
		System.out.println("Khatam ta ta godbye gaya");
	}
	
}
