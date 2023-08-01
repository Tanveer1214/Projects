package com.student.repository;

import org.springframework.data.repository.CrudRepository;

import com.student.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

	public Student getById(int id);
	
}
