package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.BookIssueDetails;

public interface BookIssueDetailsRepo extends JpaRepository<BookIssueDetails,Integer> {

}