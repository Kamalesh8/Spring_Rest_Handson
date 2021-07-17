package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Department;
import com.example.demo.daoClasses.DepartmentDao;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao department;
	public List<Department> getAllDepartments() {
		
		return department.getAllDepartments();
	}

	
}