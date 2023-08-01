package com.springcore.collections.standalone;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Temp {
	
	private List<String> list;
	private Map<Integer, String> roll;
	private Properties properties;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<Integer, String> getRoll() {
		return roll;
	}

	public void setRoll(Map<Integer, String> roll) {
		this.roll = roll;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Temp [list=" + list + ", roll=" + roll + ", properties="+ properties +"]";
	}
	
}
