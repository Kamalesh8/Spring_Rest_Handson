package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.springlearn.*;

import exception.EmployeeNotFoundException;
import service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@RequestMapping(value="/employees",method = RequestMethod.GET)
	List<Employee> getAllEmployees(){
		//returns list of all employees
		return empService.getAllEmployees();		
	}
	
	@RequestMapping(value="/employees/{id}",method = RequestMethod.PUT)
	public Employee updateEmployee( @RequestBody Employee employee) throws EmployeeNotFoundException {		
		return empService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
		empService.deleteEmployee(id);
	}
}