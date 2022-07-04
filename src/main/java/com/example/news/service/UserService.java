package com.example.news.service;

import com.example.news.model.Blog;
import com.example.news.model.User;
import com.example.news.repo.BlogRepository;
import com.example.news.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;

    public User createUser(String name, String email, String password) {
        User newUser = new User(name, email, password);
        this.userRepository.save(newUser);
        return newUser;
    }

    public Optional<User> findUserById(Long id) {
        Optional<User> user = Optional.ofNullable(this.userRepository.findUserById(id));
        return user;
    }

    public List<User> findAll() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public User updateUserEmail(Long id, String email) {
        User user = this.userRepository.findUserById(id);
        user.setEmail(email);
        this.userRepository.save(user);
        return user;
    }

    public ResponseEntity<User> updateUserPassword(Long id, String password) {
        User user;
        //this.userRepository.save(user);
        try {
            user = this.userRepository.findUserById(id);
            user.setPassword(password);
            return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
        } catch (Exception e) {
            throw  e;
        }
        //return user;
    }
}
