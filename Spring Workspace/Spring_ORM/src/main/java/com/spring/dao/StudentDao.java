package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.entities.Student;


public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	public Student getStudent(int id) {
		return this.hibernateTemplate.get(Student.class, id);
	}
	
	
	public List<Student> getAllStudents() {
		return this.hibernateTemplate.loadAll(Student.class);
	}
	
	@Transactional
	public void deleteStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	// Getter and Setter
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
