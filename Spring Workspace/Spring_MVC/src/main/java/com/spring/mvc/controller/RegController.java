package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.spring.mvc.entities.User;
import com.spring.mvc.service.UserService;

@Controller
public class RegController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/reg")
	public String Form() {
		return "register";
	}
	
	@RequestMapping(path="/process",method = RequestMethod.POST)
	public String Process(@ModelAttribute User user, Model model) {
		this.userService.createUser(user);
		return "formdata";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	/*
	 @RequestMapping(path="/process",method = RequestMethod.POST)
	public String Process(@RequestParam("email") String email, @RequestParam("pass") String password, Model model) {
		System.out.println(email);
		System.out.println(password);
		
		model.addAttribute("email",email);
		model.addAttribute("pass",password);
		
		return "formdata";
	}
	 */
	
}
