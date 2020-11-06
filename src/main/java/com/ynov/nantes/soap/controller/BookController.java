package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Book;
import com.ynov.nantes.soap.repository.BookRepository;

@RestController

public class BookController {

    private BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    
    @GetMapping("/books")
    List<Book> getAuthors() {
      return this.bookRepository.findAll();
    }
    
    
    @GetMapping("/book/{id}")
    Book getAuthorByTitle(@PathVariable String title) {
      return this.bookRepository.findBookByTitle(title);
    }
    
    @PostMapping("/book")
    Book newAuthor(@RequestBody Book book) {
      
        System.out.println(book.getAuthor());
        System.out.println(book.getAuthor());
       
       
      return this.bookRepository.save(book);
    }
    
    @DeleteMapping("/book/{id}")
    void rmAuthorById(@PathVariable int id) {
        this.bookRepository.deleteById(id);
    }
    
}
