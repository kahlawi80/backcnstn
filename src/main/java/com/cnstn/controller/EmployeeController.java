package com.cnstn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnstn.entities.Employee;
import com.cnstn.service.BackServiceEmployee;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	BackServiceEmployee backServicEmployee;

	@PostMapping
	public Employee createEmp(@RequestBody Employee employee) {
		Employee savedEmp = backServicEmployee.addEmployee(employee);
		return savedEmp;
	}

	@GetMapping("list")
	public List<Employee> getAllEmp() {
		List<Employee> employees = backServicEmployee.AfficherListEmp();
		return employees;
	}

	@GetMapping("{id}")
	public Employee LoadEmployeeById(@PathVariable("id") Long id) {
		Employee employee = backServicEmployee.LoadEmployeeById(id);
		return employee;
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
		backServicEmployee.deleteEmployee(id);
		return new ResponseEntity<>("employee successfully deleted!", HttpStatus.OK);
	}

	@PutMapping("{id}")

	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		employee.setId(id);
		Employee updatedEmployee = backServicEmployee.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}
}
