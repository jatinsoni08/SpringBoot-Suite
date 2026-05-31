package com.example.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmanagement.entity.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {

	

}
