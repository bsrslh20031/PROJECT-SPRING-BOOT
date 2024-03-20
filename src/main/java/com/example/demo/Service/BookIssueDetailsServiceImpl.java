package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.BookIssueDetails;
import com.example.demo.Repository.BookIssueDetailsRepo;
@Service
public class BookIssueDetailsServiceImpl implements BookIssueDetailsService{
	@Autowired
	BookIssueDetailsRepo bookissuedetailsRepoObject;
	
	public BookIssueDetailsServiceImpl(BookIssueDetailsRepo bookissuedetailsRepoObject) {
		this.bookissuedetailsRepoObject=bookissuedetailsRepoObject;
	}
    
	@Override
	public BookIssueDetails getBookIssue(Integer id) {
		Optional<BookIssueDetails> obj=bookissuedetailsRepoObject.findById(id);
		return obj.get();
	}



	@Override
	public String insertBookIssue(BookIssueDetails bookissuedetailsObject) {
		bookissuedetailsRepoObject.save(bookissuedetailsObject);
		return "Saved the Book issue record";
	}



	@Override
	public String updateBookIssue(BookIssueDetails bookissuedetailsObject) {
		bookissuedetailsRepoObject.save(bookissuedetailsObject);
		return "Updated the book issue Record";
	}

	@Override
	public List<BookIssueDetails> getAllBookIssues() {
		List<BookIssueDetails> listOfBookissues=bookissuedetailsRepoObject.findAll();
		System.out.println("The books present in the table");
		for(BookIssueDetails bookissuedetails:listOfBookissues) {
			System.out.println(bookissuedetails);
		}
		return listOfBookissues;
	}
	

	
}
