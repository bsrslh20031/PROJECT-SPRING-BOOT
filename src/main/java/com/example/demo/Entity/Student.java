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
@Table(name="Student")
public class Student{
	@Id
	@Column(name="studentid")
	private Integer studentid;
	@Column(name="studentname")
	private String studentname;
	@Column(name="studentcardid")
	private Integer studentcardid; 
	@Column(name="studentemail")
	private String studentemail;
	@Column(name="studentphno")
	private String studentphno;
	@OneToMany(mappedBy = "student")
	private List<BookIssueDetails> bookIssues;

	@Override
	public String toString() {
		return "[studentid:"+studentid+"studentname:"+studentname+"studentcardid"+studentcardid+"studentemail:"+studentemail+"studentphno:"+studentphno+"]";
	}
}