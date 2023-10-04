package com.mycompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("") // Must be empty for the homepage of the application
    public String showHomePage() {
        System.out.println("main controller"); // Gives us a message inthe console when the page is loaded
        return "index"; // Is empty so its mapped to the page first. We map this so we can have a mapped html
    }
}
