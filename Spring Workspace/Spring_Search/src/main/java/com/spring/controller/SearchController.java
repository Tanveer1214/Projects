package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	@RequestMapping("/toogle")
	public String Home() {
//		String s = null;
//		System.out.println(s.length());
		System.out.println("Home Controller is Running...");
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView Search(@RequestParam("query") String query) {
		RedirectView redirectView = new RedirectView();
		if(query.isBlank() || query.isEmpty()) {
			redirectView.setUrl("toogle");
			return redirectView;
		}
		String url = "http://www.google.com/search?q="+query;
		redirectView.setUrl(url);
		return redirectView;
	}
	
	
//	@ExceptionHandler(value=Exception.class)
//	public String exceptionHandler(Model model) {
//		model.addAttribute("msg","Exception has occured");
//		return "excep";
//	}
	
}
