package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class TaskController {
    

    @Controller
    public String TaskController{
        @GetMapping("/tasks")
        public String home(){
            return "tasks";
        }
    }
}
