package com.example.demo.Entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="Issue")
public class BookIssueDetails {
	@Id
	@Column(name="issueid")
	private Integer issueid;
	@Column(name="issuedate")
	private Timestamp issuedate;
	@Column(name="returningdate")
	private Timestamp returningdate;
	@Column(name="period")
	private Integer period;
	@Column(name="cardid")
	private Integer cardid;
	@ManyToOne
	@JoinColumn(name = "bookid")
	private Book book;
	@ManyToOne
	@JoinColumn(name = "studentid")
	private Student student;
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;

	
	@Override
	public String toString() {
		return "[issueid:"+issueid+"issuedate:"+issuedate+"returningdate:"+returningdate+"period"+period+"cardid"+cardid+"]";
	}

}
