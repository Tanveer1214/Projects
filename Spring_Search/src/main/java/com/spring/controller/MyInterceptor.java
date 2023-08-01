package com.spring.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor, WebMvcConfigurer {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Pre Handler");
		//Student student  = (Student) request.getSession().getAttribute("std");
		String name = (String) request.getParameter("name");
		if(name != null) {
			if(name.startsWith("T")) {
				response.setContentType("text/html");
				response.getWriter().println("<h1>Invalid Name..</h1>");
				System.out.println("Invalid Name..");
				return false;
			}
		}
		System.out.println("Student = "+name);
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Post Handler");
        String message = (String) modelAndView.getModel().get("name");
        System.out.println(message);
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("After Completion Handler");
	}
	
	 public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(this);
	 }
	
}
