package com.example.news.service;

import com.example.news.model.Blog;
import com.example.news.model.User;
import com.example.news.repo.BlogRepository;
import com.example.news.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;

    public Blog createBlog(Long id, String title, String content) {
        User user = this.userRepository.findUserById(id);
        Blog newBlog = new Blog(user, title, content);
        this.blogRepository.save(newBlog);
        return newBlog;
    }

    public Optional<Blog> findBlogById(Long id) {
        Optional<Blog> blog = this.blogRepository.findById(id);
        return blog;
    }

    public List<Blog> findAll() {
        List<Blog> blogs = this.blogRepository.findAll();
        return blogs;
    }
}
