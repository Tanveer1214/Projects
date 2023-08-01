package com.student.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entities.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	// add single student controller
	@PostMapping("/student/add")
	public Student Add(@RequestBody Student student) {
		return studentService.addStudent(student); 
	}
	
	// delete student controller
	@DeleteMapping("/student/delete/{id}")
	public String Delete(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	// update student controller
	@PutMapping("/student/update/{id}")
	public String Update(@RequestBody Student student,@PathVariable int id) {
		return studentService.updateStudent(student, id);
	}
	
	// get all students controller
	@GetMapping("/student/get")
	public Iterable<Student> GetAll() {
		return studentService.getStudents();
	}
	
	// get single student controller 
	@GetMapping("/student/get/{id}")
	public Optional<Student> GetOne(@PathVariable int id) {
		return this.studentService.getSingleStudent(id);
	}
	
	// OneToOne Controller 
	@PostMapping("/student/add/uni")
	public Student AddUni(@RequestBody Student student) {
		return studentService.addUniversity(student);
	}
	
}
