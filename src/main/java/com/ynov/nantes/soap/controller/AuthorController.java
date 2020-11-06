package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Author;
import com.ynov.nantes.soap.repository.AuthorRepository;

@RestController
public class AuthorController {
    
    private AuthorRepository authorRepository;


    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    @GetMapping("/authors")
    List<Author> getAuthors() {
      return this.authorRepository.findAll();
    }
    
    
    @GetMapping("/author/{id}")
    Author getAuthorById(@PathVariable int id) {
      return this.authorRepository.findAuteurById(id);
    }
    
    @PostMapping("/author")
    Author newAuthor(@RequestBody Author auhtor) {
      return this.authorRepository.save(auhtor);
    }
    
    @DeleteMapping("/author/{id}")
    void rmAuthorById(@PathVariable int id) {
        this.authorRepository.deleteById(id);
    }
}
