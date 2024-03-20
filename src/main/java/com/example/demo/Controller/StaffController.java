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

import com.example.demo.Entity.Staff;
import com.example.demo.Service.StaffService;
@CrossOrigin
@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	StaffService staffServiceObject;
	
	public StaffController(StaffService staffServiceObject) {
		this.staffServiceObject=staffServiceObject;
	}
	
	@GetMapping("/getstaff/{id}")
	public ResponseEntity<Staff> get(@PathVariable("id") Integer id)
	{
		Staff obj=staffServiceObject.getStaff(id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@GetMapping("/getAllStaffs")
	public ResponseEntity<List<Staff>> getall(){
		List<Staff> listOfStaffs=staffServiceObject.getAllStaffs();
		return new ResponseEntity<List<Staff>>(listOfStaffs,HttpStatus.OK);
	}
	
	@PostMapping("/insertstaff")
	public ResponseEntity<String> insert(@RequestBody Staff staffObject){
		System.out.println(staffObject);
		String msg=staffServiceObject.insertStaff(staffObject);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatestaff")
	public ResponseEntity<String> update(@RequestBody Staff staffObject){
		String msg=staffServiceObject.updateStaff(staffObject);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	

}

