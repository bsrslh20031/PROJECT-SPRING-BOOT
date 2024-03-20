package com.example.demo.Service;

import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.NoBookFoundException;
import com.example.demo.Entity.Book;
import com.example.demo.Exception.BookAlreadyExistsException;
import com.example.demo.Repository.BookRepo;
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepo bookRepoObject;
	
	public BookServiceImpl(BookRepo bookRepoObject) {
		this.bookRepoObject=bookRepoObject;
	}

	@Override
	public Book getBook(Long id) {
		return bookRepoObject.findById(id).orElseThrow(()
                -> new NoSuchElementException(
                    "NO BOOK PRESENT WITH ID = " + id));
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> listOfBooks=bookRepoObject.findAll();
		System.out.println("The books present in the table");
		for(Book book:listOfBooks) {
			System.out.println(book);
		}
		return listOfBooks;
	}

	@Override
	public String insertBook(Book bookObject) {
		Book existingbook
        = bookRepoObject.findById(bookObject.getBookid())
              .orElse(null);
    if (existingbook == null) {
        bookRepoObject.save(bookObject);
        return "Book added successfully";
    }
    else
        throw new BookAlreadyExistsException(
            "Book already exists!!");
	}

	@Override
	public String updateBook(Book bookObject) {
		Book existingbook
        =bookRepoObject.findById(bookObject.getBookid())
              .orElse(null);
    if (existingbook == null)
        throw new NoBookFoundException(
            "No Such Book exists!!");
    else {
        existingbook.setAuthorname(bookObject.getAuthorname());
        bookRepoObject.save(existingbook);
        return "Record updated Successfully";
    }
}

	@Override
	public String deleteBook(Long id) {
		bookRepoObject.deleteById(id);
		return "Removed Book with id:"+id;
	}

	
}
