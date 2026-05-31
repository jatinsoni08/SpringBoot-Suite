package com.example.bookmanagement.service;

import java.util.List;

import com.example.bookmanagement.entity.Book;

public interface BookService {
	
	Book saveBook(Book book);
	
	List<Book> getAllBook();
	
	void deleteBook(Integer id);
	
	Book updateBook(Integer id , Book book);
	
	Book getBookById(Integer id );

}
