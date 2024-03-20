package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepo studentRepoObject;
	
	public StudentServiceImpl(StudentRepo studentRepoObject) {
		this.studentRepoObject=studentRepoObject;
	}

	@Override
	public Student getStudent(Integer id) {
		Optional<Student> obj=studentRepoObject.findById(id);
		return obj.get();
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> listOfStudents=studentRepoObject.findAll();
		System.out.println("The students present in the table");
		for(Student student:listOfStudents) {
			System.out.println(student);
		}
		return listOfStudents;
	}

	@Override
	public String insertStudent(Student studentObject) {
		studentRepoObject.save(studentObject);
		return "Saved the Student";
	}

	@Override
	public String updateStudent(Student studentObject) {
		studentRepoObject.save(studentObject);
		return "Updated the Student";
	}

	@Override
	public String deleteStudent(Integer id) {
		studentRepoObject.deleteById(id);
		return "Removed Student with id:"+id;
	}
}
