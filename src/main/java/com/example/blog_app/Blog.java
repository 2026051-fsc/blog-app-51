package com.example.blog_app;

public class Blog {
    private String title;
    private String comment;
    private Long id;

    public Blog(String title, String comment,Long id){
        this.title = title;
        this.comment = comment;
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public String getComment(){
        return comment;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(Long id) {
        this.id = id;
    }
}