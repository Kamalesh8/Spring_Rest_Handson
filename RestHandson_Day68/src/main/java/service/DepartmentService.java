package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.Department;

import dao.DepartmentDAO;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO department;
	
	public List<Department> getAllDepartments() {		
		return department.getAllDepartments();
	}	
}