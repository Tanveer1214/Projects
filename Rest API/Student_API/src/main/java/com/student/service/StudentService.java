package com.student.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.student.entities.Student;
import com.student.repository.StudentRepo;

@Service
public class StudentService {
	
	private final StudentRepo studentRepo;
	// constructor for object initialization
	public StudentService(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	// add single student
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	
	// delete a student
	public String deleteStudent(int id) {
		Optional<Student> student = studentRepo.findById(id);
		if(student.isEmpty()) {
			return "Given Id of Student not exists";
		}
		studentRepo.deleteById(id);
		return "Student Deleted Successfully";
	}
	
	// update student
	public String updateStudent(Student student, int id) {
		if(studentRepo.findById(id).isEmpty()) {
			return "Given Id of Student not exists";
		}
		Student student2 = studentRepo.getById(id);
		if(student2 != null) {
			student2.setName(student.getName());
			student2.setCity(student.getCity());
			student2.getUniversity().setUniName(student.getUniversity().getUniName());
			student2.getUniversity().setDeptName(student.getUniversity().getDeptName());
			student2.getUniversity().setBatchName(student.getUniversity().getBatchName());
			studentRepo.save(student2);
		}
		return "Student Updated Successfully";
	}
	
	// get all students
	public Iterable<Student> getStudents() {
		Iterable<Student> list = studentRepo.findAll();
		return list;
	}
	
	// get single student
	public Optional<Student> getSingleStudent(int id) {
		return studentRepo.findById(id);
	}
	
	// OneToOne 
	public Student addUniversity(Student student) {
		return studentRepo.save(student);
	}
	
}
