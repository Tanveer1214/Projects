package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {

	@RequestMapping("/{id}")
	public String Handler(@PathVariable("id") int id) {
		return "index";
	}
	
	@RequestMapping("/{id}/{name}")
	public String Home(@PathVariable("id") int id, @PathVariable("name") String name) {
		return "index";
	}
	
}
