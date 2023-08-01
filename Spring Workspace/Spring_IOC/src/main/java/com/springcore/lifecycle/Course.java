package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Course implements InitializingBean, DisposableBean {
	private int Cid;
	private String Cname;
	private String Cduration;
	private String CBatch;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getCduration() {
		return Cduration;
	}

	public void setCduration(String cduration) {
		Cduration = cduration;
	}

	public String getCBatch() {
		return CBatch;
	}

	public void setCBatch(String cBatch) {
		CBatch = cBatch;
	}

	@Override
	public String toString() {
		return "Course [Cid=" + Cid + ", Cname=" + Cname + ", Cduration=" + Cduration + ", CBatch=" + CBatch + "]";
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("This is init method runing from Course class");
	}

	public void destroy() throws Exception {
		System.out.println("This is destroy method runing from Course class");
	}
	
}
