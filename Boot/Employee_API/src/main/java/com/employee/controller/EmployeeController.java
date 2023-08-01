package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	
	// get all employees controller
	@GetMapping("/")
	public String getAllEmployees(Model model) {
		model.addAttribute("list",employeeService.getAllEmployees());
		return "home";
	}
	
	@GetMapping("/add-employee")
	public String showAddForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);	
		return "add-form";
	}
	
	// save employee controller
	@PostMapping("/add-employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	
	// get single employee
	@GetMapping("/update/{id}")
	public String getEmployee(@PathVariable("id") Long id, Model model) {
		Employee employee = employeeService.getEmployee(id);
		model.addAttribute("employee",employee);
		return "update-form";
	}
	
//	// update employee
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
//		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
//	}
	
	// delete employee
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
	
}
