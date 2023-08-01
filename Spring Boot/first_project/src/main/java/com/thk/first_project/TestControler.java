package com.thk.first_project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestControler {
	
	public TestControler() {
		System.out.println("Controller class is runing...");
	}
    
    @RequestMapping("/test")
    public String handle() {
        System.out.println("This is home page");
        return "home";
    }

    @RequestMapping("/hello")
    public String fun() {
        System.out.println("This is another jsp page");
        return "tani";
    }

}
