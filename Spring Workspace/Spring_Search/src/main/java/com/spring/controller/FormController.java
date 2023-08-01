package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FormController {
	
	@RequestMapping("/")
	public String Home() {
		return "index";
	}
	
	@RequestMapping("/form")
	public String Form() {
		return "complex-form";
	}
	
//	@RequestMapping(path = "/handle", method = RequestMethod.POST)
//	public String formHandler(@ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
//		if(bindingResult.hasErrors()) {
//			return "complex-form";
//		}
//		System.out.println(student);
//		model.addAttribute("std",student);
//		return "success";
//	}
	
	
	@RequestMapping(path = "/handle", method = RequestMethod.POST)
	public String formHandler(@RequestParam("name") String name, HttpServletRequest request, Model model) {
		System.out.println(name);
		model.addAttribute("name",name);
		return "success";
	}
	
}
