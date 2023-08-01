package com.spring.entities;

import java.util.Date;
import java.util.List;


public class Student {
	
	private String name;
	private Long id;
	private Date date;
	private List<String> subjects;
	private String gender;
	private String type;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, Long id, Date date, List<String> subjects, String gender, String type) {
		super();
		this.name = name;
		this.id = id;
		this.date = date;
		this.subjects = subjects;
		this.gender = gender;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", date=" + date + ", subjects=" + subjects + ", gender="
				+ gender + ", type=" + type + "]";
	}
	
}
