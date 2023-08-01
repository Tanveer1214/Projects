package com.thk.test.entities;

public class Books {
	
	private int id;
	private String tittle;
	private String author;
	
	public Books(int id, String tittle, String author) {
		this.id = id;
		this.tittle = tittle;
		this.author = author;
	}

	public Books() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", tittle=" + tittle + ", author=" + author + "]";
	}
	
	
}
