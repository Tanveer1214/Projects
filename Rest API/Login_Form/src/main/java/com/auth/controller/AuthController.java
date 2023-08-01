package com.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.auth.entities.UserData;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("data", new UserData());
		return "loginform";
	}
	
	@PostMapping("/process")
	public String processData(@Valid @ModelAttribute("data") UserData data, BindingResult result) {
		if(result.hasErrors()) {
			return "loginform";
		}
		return "processform";
	}
	
}
