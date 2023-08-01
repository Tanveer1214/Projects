package com.springcore.collections;

import java.util.List;
import java.util.Set;
import java.util.Map;

public class Person {
	private String name;
	private List<String> projects;
	private Set<String> addresses;
	private Map<Integer,String> grudation;
	
	public Person(String name, List<String> projects, Set<String> addresses, Map<Integer, String> grudation) {
		super();
		this.name = name;
		this.projects = projects;
		this.addresses = addresses;
		this.grudation = grudation;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}

	public Set<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<String> addresses) {
		this.addresses = addresses;
	}

	public Map<Integer, String> getGrudation() {
		return grudation;
	}

	public void setGrudation(Map<Integer, String> grudation) {
		this.grudation = grudation;
	}
	
	
	
}
