package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
    private final JdbcClient jdbcClient;

    public BlogRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

  public List<Blog> findAll() {
    return jdbcClient.sql("SELECT title, comment,id FROM blogs")
        .query(Blog.class)
        .list();
  }

    public Optional<Blog> findById(Long id){
        return jdbcClient.sql("SELECT id,title,comment FROM blogs WHERE id = :id")
        .param("id",id)
        .query(Blog.class)
        .optional();
    }

    public void save(Blog blog){
        jdbcClient.sql("INSERT INTO blogs(title,comment) VALUES(:title,:comment)")
        .param("title",blog.getTitle())
        .param("comment",blog.getComment())
        .update();
    }

//     public boolean existsByTitle(String title) {
//     Long count = jdbcClient.sql("SELECT COUNT(*) FROM books WHERE title = :title")
//         .param("title", title)
//         .query(Long.class)
//         .single();
//     return count > 0;
// }
        

}
