package com.example.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;

	public BookServiceImpl(BookRepository repository) {

		this.repository = repository;
	}

	@Override
	public Book saveBook(Book book) {
		return repository.save(book);

	}

	@Override
	public List<Book> getAllBook() {
		return repository.findAll();

	}

	@Override
	public void deleteBook(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public Book updateBook(Integer id, Book book) {
		Book bookser = repository.findById(id).orElse(null);
		if (bookser != null) {
			bookser.setTitle(book.getTitle());
			bookser.setAuthor(book.getAuthor());
			bookser.setPrice(book.getPrice());

			return repository.save(bookser);

		}
		return null;
	}

	@Override
	public Book getBookById(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
