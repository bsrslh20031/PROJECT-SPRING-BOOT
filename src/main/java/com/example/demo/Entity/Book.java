package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Book")
public class Book {
	@Id
	@Column(name="bookid")
	private Long bookid;
	@Column(name="booktitle")
	private String booktitle;
	@Column(name="authorname")
	private String authorname;
	@Column(name="booksavailable")
	private Integer booksavailable;
	@OneToMany(mappedBy = "book")
	private List<BookIssueDetails> bookIssues;
	@Override
	public String toString() {
		return "[bookid"+bookid+"booktitle"+booktitle+"authorname"+authorname+"booksavailable"+booksavailable+"]";
	}

}