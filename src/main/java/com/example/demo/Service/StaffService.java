package com.example.demo.Service;

import java.util.List;


import com.example.demo.Entity.Staff;

public interface StaffService {
	public Staff getStaff(Integer id);
	public List<Staff> getAllStaffs();
	public String insertStaff(Staff staffObject);
	public String updateStaff(Staff staffObject);
	


}