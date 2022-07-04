package com.example.news.controller;

import com.example.news.model.Blog;
import com.example.news.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/blog/create")
    public Blog create(@RequestBody Map<String, String> body){
        String userId = body.get("userId");
        String title = body.get("title");
        String content = body.get("content");
        Long id = Long.parseLong(userId);
        //return blogRespository.save(new Blog(title, content));
        return blogService.createBlog(id, title, content);
    }

    @GetMapping("/blog/findById")
    public Optional<Blog> findById(@RequestBody Map<String, String> body){
        String blogId = body.get("blogId");
        Long id = Long.parseLong(blogId);
        return blogService.findBlogById(id);
    }

    @GetMapping("/blog/findAll")
    public List<Blog> findAll(){
        return blogService.findAll();
    }

    @GetMapping("/blog/findAllBlogs")
    public List<Blog> findAllBlogs(@RequestBody Map<String, String> body){
        return blogService.findAll();
    }
}
