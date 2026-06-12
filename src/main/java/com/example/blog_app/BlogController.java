package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @GetMapping("/sample")
    public String sample(@RequestParam String title,Model model){
        model.addAttribute("title",title);
        return "sample";
    }

    @GetMapping("/blogs")
    public String blog(Model model){
        model.addAttribute("books",blogRepository.findAll())
        return "blogs";
    }

    
}
