package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs",blogs);
        return "home";
    }

    @GetMapping("/sample")
    public String sample(@RequestParam String title, Model model) {
        model.addAttribute("title", title);
        return "sample";
    }

        @GetMapping("/profile")
    public String profile() {
        return "home";
    }
    

@GetMapping("/home/{id}")
public String detail(@PathVariable Long id, Model model) {
  Optional<Blog> blogOpt = blogService.findById(id);
  if (blogOpt.isEmpty()) {
    return "redirect:/home";
  }
  model.addAttribute("blogs", blogOpt.get());
  return "blog/read";
}
    // @PostMapping("/blogs")
    // public String create(@ModelAttribute BlogForm form){
    // blogService.register(form);
    // return "redirect:/blogs";
    // }

    @GetMapping("/blogs/{id}/deit")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Blog> blogOpt = blogService.findById(id);
        if (blogOpt.isEmpty()) {
            return "redirect:/blogs";
        }
        Blog blog = blogOpt.get();

        BlogForm form = new BlogForm();
        form.setTitle(blog.getTitle());
        form.setComment(blog.getComment());
        model.addAttribute("blogForm", form);
        model.addAttribute("blogId", id);
        return "blog/edit";
    }

    // @GetMapping("/blogs")
    // public String blog(@RequestParam(required = false) String keyword, Model
    // model){
    // model.addAttribute("blogs",blogRepository.search(keyword));
    // return "redirect:/blogs";
    // }

    @GetMapping("/write")
    public String write(){
        return "write";
    }

    @PostMapping("/post")
    public String postMethodName(BlogForm form) {
        blogService.register(form);
        
        return "redirect:/home";
    }
    
}
