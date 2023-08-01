package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("getStudentDao")
public class StudentDaoImp implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		String query="insert into student(id,name,city) values(?,?,?)";
		return this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int update(Student student) {
		String query="update student set name = ?, City = ? where ID = ?";
		return this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
	}

	public int delete(int id) {
		String query = "delete from student where ID = ?";
		return this.jdbcTemplate.update(query,id);
	}

	public Student getStudent(int id) {
		RowMapper<Student> rowMapper = new RowMapperImp();
		String query = "select * from student where id = ?";
		return this.jdbcTemplate.queryForObject(query, rowMapper,id);
	}

	public List<Student> getAllStudents() {
		String query = "select * from student";
		List<Student> student = this.jdbcTemplate.query(query, new RowMapperImp());
		return student;
	}

}
