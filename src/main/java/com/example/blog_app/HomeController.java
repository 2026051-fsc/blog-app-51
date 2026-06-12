package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";
        
    }

    @GetMapping("/profile")
    public String profile() {
        return "home";
    }
    

    @GetMapping("/read")
    public String read(){
        return "read";
    }

    @GetMapping("/write")
    public String write(){
        return "write";
    }
}
