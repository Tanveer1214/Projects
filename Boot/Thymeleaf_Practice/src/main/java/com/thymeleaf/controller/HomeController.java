package com.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thymeleaf.model.Student;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Home(Model model) {
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("Spring");
		list.add("Spring boot");
		list.add("Android");
		model.addAttribute("list",list);
		return "index";
	}
	
	@GetMapping("/student")
	public String listOfStudent(Model model) {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Tanveer", "Mehrabpur"));
		list.add(new Student(2, "Sammer", "Mehrabpur"));
		list.add(new Student(3, "Sagar", "Nawabshah"));
		model.addAttribute("student",list);
		return "student-info";
	}
	
}
