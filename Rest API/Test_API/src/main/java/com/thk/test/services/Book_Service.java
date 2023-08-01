package com.thk.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.thk.test.entities.Books;

@Component
public class Book_Service {
	
	private static List<Books> list = new ArrayList<>();

	static {
		list.add(new Books(10,"Java The Compelete Refference","Abc"));
		list.add(new Books(20,"Think like a programmer","Xyz"));
		list.add(new Books(30,"Introduction to Algorithm","Etc"));
	}
	
	public List<Books> getAllBooks() {
		return list;
	}
	
	public Books getBookById(int id) {
		Books book = null;
		try {
			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Books addBook(Books b) {
		list.add(b);
		return b;
	}
	
	public void deleteBook(int id) {
		list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
	}
	
	public void updateBook(Books book, int id) {
		list = list.stream().map(b -> {
			if(b.getId() == id) {
				b.setTittle(book.getTittle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
	
}
