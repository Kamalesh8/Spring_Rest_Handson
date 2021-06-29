package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.Employee;

import dao.EmployeeDAO;
import exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeedao;

	public List<Employee> getAllEmployees(){		
		return employeedao.getAllEmployee();
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		return employeedao.updateEmployee(employee);
	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException {		
		employeedao.deleteEmployee(id);		
	}	
}