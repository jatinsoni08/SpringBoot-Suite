package com.example.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;

	public BookController(BookService service) {
		this.service = service;
	}
	
	@PostMapping("/save")
	public Book saveAllbook(@RequestBody Book book) {
		return service.saveBook(book);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBook(@PathVariable Integer id) {
		service.deleteBook(id);
	}
	
	@GetMapping("/get-allbook")
		public List<Book> getAllBook(){
		return service.getAllBook();
	}
	
	@PutMapping("/update/{id}")
	public Book updateBook(@RequestBody Book book  , @PathVariable Integer id) {
		return service.updateBook(id, book);
	}
	
	@GetMapping("/getoneBook/{id}")
	public Book getBookById(@PathVariable Integer id ) {
		return service.getBookById(id);
	}
	
}
