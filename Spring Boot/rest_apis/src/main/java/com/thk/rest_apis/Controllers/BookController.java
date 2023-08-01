package com.thk.rest_apis.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    @GetMapping("/books")
    public String getBooks() {
        return "This is Test of getBooks Method...etc";
    }

}
