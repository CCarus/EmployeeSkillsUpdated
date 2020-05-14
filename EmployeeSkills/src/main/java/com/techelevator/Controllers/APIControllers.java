package com.techelevator.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.Dao.EmployeeDao;
import com.techelevator.Dao.SkillsDao;
import com.techelevator.Model.Employee;
import com.techelevator.Model.Skills;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class APIControllers {

	@Autowired
	private EmployeeDao employeeDAO;



	@GetMapping("/employees")
	public List<Employee> displayAllEmployees() {
		List<Employee> allEmployees = employeeDAO.getAllEmployees();
		return allEmployees;
	}

	@PostMapping("/employees")
	@ResponseStatus(HttpStatus.CREATED)
	public void addNewEmployee(@RequestBody Employee employee) {
		
		employee.setEmployeeID(UUID.randomUUID());
		employeeDAO.createNewEmployee(employee);

	}

	@GetMapping("/employees/{employeeID}")
	public Employee displayEmployeeById(@PathVariable UUID employeeID) {
		Employee employee = employeeDAO.getEmployeeById(employeeID);
		return employee;
	}

	@PutMapping("/employees/{employeeID}")
	public void updateEmployeeById(@RequestBody Employee employee, @PathVariable UUID employeeID ) {
		
		employeeDAO.updateEmployee(employee, employeeID);
	
	}

	@DeleteMapping("/employees/{employeeID}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployeeById(@PathVariable UUID employeeID) {
		employeeDAO.deleteEmployee(employeeID);
	}

	
}
