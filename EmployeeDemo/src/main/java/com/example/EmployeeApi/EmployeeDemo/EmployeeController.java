package com.example.EmployeeApi.EmployeeDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
	private EmployeeManager employeeManager;
	
	@Autowired
    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }
	
	@GetMapping
	public Employees getEmployees() {
		return employeeManager.getEmployee();
	}
	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId) {
		return employeeManager.getEmployeeUsingID(employeeId);
		
		
	}
	@PostMapping
	public String addEmployees(@RequestBody Employee employee) {
		employeeManager.addEmployee(employee);
		return "Added Successfully";
	}
	@PutMapping(path="/{employeeId}")
	public String updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee) {
	    try {
			employeeManager.updateEmployee(employeeId, employee);
			return "Updated Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
			//return "No Employee with this ID Exists";
		}
	}
	
	@DeleteMapping(path="/{employeeId}")
	public String deleteEmployee(@PathVariable String employeeId) {
		try {
			employeeManager.deleteEmployee(employeeId);
			return "Deleted Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
			//return "No Employee with this ID Exists";
		}
	}

}
