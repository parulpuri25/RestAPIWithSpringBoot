package com.example.EmployeeApi.EmployeeDemo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {
	private Employees employeeList = new Employees();

	public Employees getEmployee() {
		return employeeList;

	}

	// HARD CODE SOME EMPLOYEES
	public EmployeeManager() {
		employeeList.getEmployees().add(new Employee("1", "Charlie", "Jain", "charliej1@gmail.com", "Associate"));
		employeeList.getEmployees().add(new Employee("2", "Julie", "Green", "jg2@gmail.com", "Associate"));
		employeeList.getEmployees().add(new Employee("3", "Adams", "Singh", "adams23@gmail.com", "Associate Manager"));
	}
	// GET ONE EMPLOYEE USING ID
	public Employee getEmployeeUsingID(String employeeId) {
	    List<Employee> employees = employeeList.getEmployees();
	    for (Employee employee : employees) {
	        if (employee.getEmployee_id().equals(employeeId)) {
	            return employee;
	        }
	    }
	    throw new RuntimeException("No employee found with the ID " + employeeId);
	}


	// ADD A NEW EMPLOYEE
	public void addEmployee(Employee employee) {
		employeeList.getEmployees().add(employee);
	}

	// UPDATE AN EXISTING EMPLOYEE
	public void updateEmployee(String employeeId, Employee Uemployee) {
		   boolean match = false;
		
			List<Employee> employees = employeeList.getEmployees();

			for (int i = 0; i < employees.size(); i++) {
				Employee employee1 = employees.get(i);
				if (employee1.getEmployee_id().equals(employeeId)) {
					employees.set(i, Uemployee);
					match = true;
				}
			}
			if(!match) {
			throw new RuntimeException("No Employee Found with id "+employeeId);
             
	}
	}

	// DELETE AN EXISTING EMPLOYEE
	public void deleteEmployee(String employeeId) {
			boolean match = false;
			List<Employee> employees = employeeList.getEmployees();

			for (int i = 0; i < employees.size(); i++) {
				Employee employee1 = employees.get(i);
				if (employee1.getEmployee_id().equals(employeeId)) {
					employees.remove(i);
					match = true;
					break;
				}
			}
			if(!match) {
			throw new RuntimeException("No Employee Found with id " + employeeId); 
			}
	}
}
