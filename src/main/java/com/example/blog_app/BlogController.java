package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/sample")
    public String sample(@RequestParam String title,Model model){
        model.addAttribute("title",title);
        return "sample";
    }


        @PostMapping("/blogs")
    public String create(@ModelAttribute BlogForm form){
        blogService.register(form);
        return "redirect:/blogs";
    }

    // @GetMapping
    // public String datail(@PathVariable Long id, Model model){
    //     Optional<Blog> blogOpt = blogService.findById(id);
    //     if(blogOpt.isEmpty()){
    //         return"redirect:/blogs";
    //     }
    //     model.addAttribute("blog",blogOpt.get());
    //     return "blogs/detail"
    // }
    // @GetMapping("/blogs")
    // public String blog(@RequestParam(required = false) String keyword, Model model){
    //     model.addAttribute("blogs",blogRepository.search(keyword));
    //     return "redirect:/blogs";
    // }

    
}
