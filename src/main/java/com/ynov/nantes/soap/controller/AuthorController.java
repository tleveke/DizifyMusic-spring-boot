package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.User;
import com.ynov.nantes.soap.repository.UserRepository;

@RestController
public class AuthorController {
    
    private UserRepository userRepository;


    public AuthorController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("/users")
    List<User> getAuthors() {
      return this.userRepository.findAll();
    }
    
    
    @GetMapping("/user/{email}")
    User getAuthorById(@PathVariable String email) {
      return this.userRepository.findAuteurByEmail(email);
    }
    
    @PostMapping("/user")
    User newAuthor(@RequestBody User auhtor) {
      return this.userRepository.save(auhtor);
    }
    
    @DeleteMapping("/user/{id}")
    void rmAuthorById(@PathVariable int id) {
        this.userRepository.deleteById(id);
    }
}
