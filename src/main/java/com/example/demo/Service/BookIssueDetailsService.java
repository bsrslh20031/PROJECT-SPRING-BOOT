package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.BookIssueDetails;

public interface BookIssueDetailsService {
	public BookIssueDetails getBookIssue(Integer id);
	public List<BookIssueDetails> getAllBookIssues();
	public String insertBookIssue(BookIssueDetails bookissuedetailsObject);
	public String updateBookIssue(BookIssueDetails bookissuedetailsObject);
	

}
