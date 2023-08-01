package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	@GetMapping("/student/{id}")
	public String getId(@PathVariable("id") int id) {
		return "Your id is "+id;
	}
	
	// http://localhost:8080/student/info?id=35&name=Tanveer&city=mhr
	@GetMapping("/student/info")
	public Student getInfo(@RequestParam(name = "id") int id, 
			@RequestParam(name = "name") String name,
			@RequestParam(name = "city") String city) {
		return new Student(id,name,city);
	}
	
}
