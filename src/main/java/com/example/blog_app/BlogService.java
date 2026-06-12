package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public List<Blog> findAll(){
        return blogRepository.findAll();
    }

    public Optional<Blog> findById(Long id){
        return blogRepository.findById(id);
    }

  public void register(BlogForm form) {
    if(form.getTitle() == null || form.getTitle().isEmpty()){
        throw new IllegalArgumentException("タイトルを入力してください");
    }
    // ビジネスルール 1: 価格は 100 以上
    // if (form.getPrice() < 100) {
    //   throw new IllegalArgumentException("価格は 100 以上で指定してください");
    // }
    // ビジネスルール 2: 同じタイトルは登録しない
    // if (blogRepository.existsByTitle(form.getTitle())) {
    //   throw new IllegalStateException("同じタイトルの本がすでに登録されています");
    // }
    blogRepository.save(new Blog(form.getTitle(), form.getComment(),null));
  }
}
