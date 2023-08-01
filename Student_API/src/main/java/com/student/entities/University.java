package com.student.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "university")
public class University {

	@Id
	private int rollNo;
	@Column
	private String uniName;
	@Column
	private String deptName;
	@Column
	private String batchName;
	@OneToOne(mappedBy = "university")
	@JsonBackReference
	private Student student;
	
	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

	public University(int rollNo, String uniName, String deptName, String batchName) {
		super();
		this.rollNo = rollNo;
		this.uniName = uniName;
		this.deptName = deptName;
		this.batchName = batchName;
	}
	
	public University(int rollNo, String uniName, String deptName, String batchName, Student student) {
		super();
		this.rollNo = rollNo;
		this.uniName = uniName;
		this.deptName = deptName;
		this.batchName = batchName;
		this.student = student;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getUniName() {
		return uniName;
	}

	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "University [rollNo=" + rollNo + ", uniName=" + uniName + ", deptName=" + deptName + ", batchName="
				+ batchName + ", student=" + student + "]";
	}

}
