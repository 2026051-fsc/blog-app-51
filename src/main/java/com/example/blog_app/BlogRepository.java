package com.example.blog_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
    private final DataSource dataSource;

    public BlogRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Blog>finalAll(){
        List <Blog>Blog = new ArrayList<>();
        String sql = "SELECT title, price, stock FROM blogs";
    }
    
    try (Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()){

        while(rs.next()){
            blogs.add(new Blog(rs.getString("title"),rs.getInt("comment")))
        }
        }
}
