package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Book;

public interface BookService {
	 public Book getBook(Long id);
	 public List<Book> getAllBooks();
	 public String insertBook(Book bookObject);
	 public String updateBook(Book bookObject);
	 public String deleteBook(Long id);

}