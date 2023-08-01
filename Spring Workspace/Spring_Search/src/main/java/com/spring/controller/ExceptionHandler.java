package com.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Model model) {
		model.addAttribute("msg","Exception has occured");
		return "excep";
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = NullPointerException.class)
	public String exceptionHandler2(Model model) {
		model.addAttribute("msg","Null Pointer Exception has occured");
		return "excep";
	}
	
}
