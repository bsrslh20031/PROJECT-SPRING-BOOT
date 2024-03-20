package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentServiceObject;
	
	public StudentController(StudentService studentServiceObject) {
		this.studentServiceObject=studentServiceObject;
	}
	
	@GetMapping("/getstudents/{id}")
	public ResponseEntity<Student> get(@PathVariable("id") Integer id)
	{
		Student obj=studentServiceObject.getStudent(id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getall(){
		List<Student> listOfStudents=studentServiceObject.getAllStudents();
		return new ResponseEntity<List<Student>>(listOfStudents,HttpStatus.OK);
	}
	
	@PostMapping("/insertstudents")
	public ResponseEntity<String> insert(@RequestBody Student studentObject){
		System.out.println(studentObject);
		String msg=studentServiceObject.insertStudent(studentObject);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatestudents")
	public ResponseEntity<String> update(@RequestBody Student studentObject){
		String msg=studentServiceObject.updateStudent(studentObject);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	@DeleteMapping("/deletestudents/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		String s=studentServiceObject.deleteStudent(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}

}

