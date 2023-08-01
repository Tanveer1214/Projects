package com.th.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyController {
	
	@GetMapping("/info")
	public String Info(Model model) {
		System.out.println("Info is running...");
		model.addAttribute("leng","Java");
		model.addAttribute("date",new Date().toString());
		return "info";
	}
	
	// thymeleaf iteration
	@GetMapping("/list")
	public String Iterate(Model model) {
		List<String> list = new ArrayList<>();
		System.out.println("Controller is running...");
		list.add("Tanveer"); list.add("Sagar"); list.add("Zubair");
		model.addAttribute("list",list);
		return "listInfo";
	}
	
	// thymeleaf conditional
	@GetMapping("/vote/{age}")
	public String canVote(Model model, @PathVariable int age) {
		model.addAttribute("age",age);
		return "voteView";
	}
	
	@GetMapping("/vote/gender/{gen}")
	public String Geneder(Model model, @PathVariable String gen) {
		model.addAttribute("gen",gen);
		return "voteView";
	}
	
	@GetMapping("/vote/reg/{vote}")
	public String giveVote(Model model, @PathVariable String vote) {
		model.addAttribute("vote",vote);
		return "voteView";
	}
	
	// thymeleaf fragments
	@GetMapping("/frag/{name}")
	public String fragHandler(@PathVariable String name, Model model) {
		model.addAttribute("name",name);
		return "frag";
	}
	
}
