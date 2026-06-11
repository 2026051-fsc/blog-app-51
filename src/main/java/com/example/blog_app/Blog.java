package com.example.blog_app;

public class Blog {
    private final String title;
    private final String comment;

    public Blog(Stirng title, String comment){
        this.title = title;
        this.comment = comment;

        public String getTitle(){
            return title;
        }

        public String getComment(){
            return comment;
        }
    }
}
