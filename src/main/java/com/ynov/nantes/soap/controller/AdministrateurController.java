package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Administrateur;
import com.ynov.nantes.soap.repository.AdministrateurRepository;

@RestController
public class AdministrateurController {
    
    private AdministrateurRepository adminRepository;


    public AdministrateurController(AdministrateurRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
    @GetMapping("/administrateurs")
    List<Administrateur> getAuthors() {
      return this.adminRepository.findAll();
    }
    
    
    @GetMapping("/administrateur/{email}")
    Administrateur getAuthorById(@PathVariable String email) {
      return this.adminRepository.findAuteurByEmail(email);
    }
    
    @PostMapping("/administrateur")
    Administrateur newAuthor(@RequestBody Administrateur auhtor) {
      return this.adminRepository.save(auhtor);
    }
    
    @DeleteMapping("/administrateur/{id}")
    void rmAuthorById(@PathVariable int id) {
        this.adminRepository.deleteById(id);
    }
}
