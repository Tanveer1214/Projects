package com.thk.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thk.test.entities.Books;
import com.thk.test.services.Book_Service;

@RestController
public class Test_Controller {

	@Autowired
	private Book_Service bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Books>> getBooks() {
		List<Books> list = this.bookService.getAllBooks();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getBook(@PathVariable("id") int id) {
		Books book = bookService.getBookById(id);
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public Books addBook(@RequestBody Books book) {
		Books b = this.bookService.addBook(book);
		return b;
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.bookService.deleteBook(id);
	}
	
	@PutMapping("/books/{id}")
	public Books updateBook(@RequestBody Books book, @PathVariable("id") int id) {
		this.bookService.updateBook(book,id);
		return book;
	}
	
}
