package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Entity.BookIssueDetails;
import com.example.demo.Service.BookIssueDetailsService;
@CrossOrigin
@RestController
@RequestMapping("/bookissue")
public class BookIssueDetailsController {
	@Autowired
	BookIssueDetailsService bookissuedetailsServiceObject;
	
	public BookIssueDetailsController(BookIssueDetailsService bookissuedetailsServiceObject) {
		this.bookissuedetailsServiceObject=bookissuedetailsServiceObject;
	}
	
	@GetMapping("/getbookissues/{id}")
	public ResponseEntity<BookIssueDetails> get(@PathVariable("id") Integer id){
		BookIssueDetails obj=bookissuedetailsServiceObject.getBookIssue(id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookIssues")
	public ResponseEntity<List<BookIssueDetails>> getall(){
		List<BookIssueDetails> listOfBookissues=bookissuedetailsServiceObject.getAllBookIssues();
		return new ResponseEntity<List<BookIssueDetails>>(listOfBookissues,HttpStatus.OK);
	}
	
	@PostMapping("/insertBookIssues")
	public ResponseEntity<String> insert(@RequestBody BookIssueDetails bookissuedetailsObject){
		System.out.println(bookissuedetailsObject);
		String msg=bookissuedetailsServiceObject.insertBookIssue(bookissuedetailsObject);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateBookIssues")
	public ResponseEntity<String> update(@RequestBody BookIssueDetails bookissuedetailsObject){
		String msg=bookissuedetailsServiceObject.updateBookIssue(bookissuedetailsObject);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	


}