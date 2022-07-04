package com.example.news.controller;

import com.example.news.model.User;
import com.example.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/create")
    public User create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String email = body.get("email");
        String password = body.get("password");
        return userService.createUser(name, email, password);
    }

    @GetMapping("/user/findById")
    public Optional<User> findById(@RequestBody Map<String, String> body){
        String userId = body.get("userId");
        Long id = Long.parseLong(userId);
        return userService.findUserById(id);
    }

    @GetMapping("/user/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/user/findAllUsers")
    public List<User> findAllUsers(@RequestBody Map<String, String> body){
        return userService.findAll();

    }

    @PutMapping("/user/updatePassword")
    public ResponseEntity updatePassword(@RequestBody  Map<String, String> body) {
        String userId = body.get("userId");
        String password = body.get("password");
        Long id = Long.parseLong(userId);
        try {
            return userService.updateUserPassword(id, password);
        } catch (Exception e) {
            return new ResponseEntity("Failed to update password", HttpStatus.I_AM_A_TEAPOT);

        }
    }

    @PutMapping("/user/updateEmail")
    public User updateEmail(@RequestBody  Map<String, String> body) {
        String userId = body.get("userId");
        String email = body.get("email");
        Long id = Long.parseLong(userId);
        return userService.updateUserEmail(id, email);
    }
}
