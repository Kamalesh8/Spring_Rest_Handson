package dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.cognizant.springlearn.*;

import exception.*;

@Component
public class EmployeeDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAO.class);
	static ArrayList<Employee> emp_list;
	
	@SuppressWarnings("unchecked")
	public EmployeeDAO() {		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		emp_list = (ArrayList<Employee>) context.getBean("employeeList");
	}
	
	public List<Employee> getAllEmployee(){
		return emp_list;
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{		
		for(Employee emp:emp_list)
		{
			if(emp.getId()==employee.getId())
			{
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setDateOfBirth(employee.getDateOfBirth());
				emp.setPermanent(employee.getPermanent());
				emp.setDepartment(employee.getDepartment());
				emp.setSkill(employee.getSkill());				
				return emp;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException
	{
		Employee flag=null;
		for(Employee emp:emp_list)
		{
			if(emp.getId()==id)
			{
				flag=emp;
						
			}
		}
		if(flag!=null)
		{
			emp_list.remove(flag);
		}
		else
		{
			throw new EmployeeNotFoundException();
		}
	}
}