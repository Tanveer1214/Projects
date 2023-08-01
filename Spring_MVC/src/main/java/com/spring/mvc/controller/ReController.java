package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {

	@RequestMapping("/first")
	public String first() {
		System.out.println("First is running...");
		return "redirect:/second";
	}
	
	@RequestMapping("/second")
	public RedirectView Second() {
		System.out.println("Second is running...");
		RedirectView redirectView = new  RedirectView();
		redirectView.setUrl("reg");
		return redirectView;
	}
	
}
