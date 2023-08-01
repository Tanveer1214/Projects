package com.spring.mvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		System.out.println("Home url....");
		return "index";
	}
	
	@RequestMapping("/tani")
	public String Tani(Model model) {
		model.addAttribute("name", "Tanveer Ali Khaskheli");
		return "tani";
	}
	
	@RequestMapping("/")
	public String Home(Model model) {
		List<String> name = new ArrayList<String>();
		name.add("Tanveer");
		name.add("Zubair");
		name.add("Sagar");
		model.addAttribute("names",name);
		return "home";
	}
	
	@RequestMapping("/greet")
	public ModelAndView Greetings() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("greet", "Iam Fine Thank You.");
		
		LocalDateTime dateTime =  LocalDateTime.now();
		modelAndView.addObject("time",dateTime);
		
		List<String> list = new ArrayList<String>();
		list.add("Hi");
		list.add("Hello");
		list.add("Hey");
		
		modelAndView.addObject("g",list);
		
		modelAndView.setViewName("greeting");
		return modelAndView;
	}
	
}
