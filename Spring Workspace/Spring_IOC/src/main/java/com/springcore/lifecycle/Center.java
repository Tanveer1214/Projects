package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Center {
	
	private String address;
	private String timing;
	
	public Center() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTiming() {
		return timing;
	}
	
	public void setTiming(String timing) {
		this.timing = timing;
	}
	
	@Override
	public String toString() {
		return "Center [address=" + address + ", timing=" + timing + "]";
	}
	
	@PostConstruct
	public void Start() {
		System.out.println("Start Method is runing");
	}
	
	@PreDestroy
	public void End() {
		System.out.println("End Method is runing");
	}
	
}
