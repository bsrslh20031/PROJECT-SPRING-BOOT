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
@Table(name="Staffs")
public class Staff {
	@Id
	@Column(name="staffid")
	private Long staffid;
	@Column(name="staffname")
	private String staffname;
	@Column(name="staffcardid")
	private Integer staffcardid;
	@Column(name="staffemail")
	private String staffemail;
	@Column(name="staffphno")
	private String staffphno;
	@Column(name="staffqualification")
	private String staffqualification;
	@OneToMany(mappedBy = "staff")
	private List<BookIssueDetails> bookIssues;
	@Override
	public String toString() {
		return "[staffid:"+staffid+"staffname:"+staffname+"staffcardid:"+staffcardid+"staffemail:"+staffemail+"staffphno:"+staffphno+"staffqualification"+staffqualification+"]";
	}

}