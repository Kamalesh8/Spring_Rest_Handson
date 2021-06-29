package dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.cognizant.springlearn.*;

@Component
public class DepartmentDAO {

	static ArrayList<Department> dept_list;
	
	@SuppressWarnings({ "unchecked", "resource" })
	public DepartmentDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		dept_list = (ArrayList<Department>) context.getBean("departmentList");
	}

	public List<Department> getAllDepartments() {
		return dept_list;
	}
}
