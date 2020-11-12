package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Administrateur;
import com.ynov.nantes.soap.entity.User;
import com.ynov.nantes.soap.repository.AdministrateurRepository;

@RestController
public class AdministrateurController {
    
    private AdministrateurRepository adminRepository;


    public AdministrateurController(AdministrateurRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
    @GetMapping("/administrateurs")
    List<Administrateur> getAdministrateurs() {
      return this.adminRepository.findAll();
    }
    
    
    @GetMapping("/administrateur/{id}")
    Administrateur getAdministrateurById(@PathVariable int id) {
      return this.adminRepository.findAdminById(id);
    }
    
    @PostMapping("/administrateur")
    Administrateur newAdministrateur(@RequestBody Administrateur admin) {
      return this.adminRepository.save(admin);
    }
    @PostMapping("/isAdministrateur")
    Boolean isAdministrateurByUser(@RequestBody User user) {
      return this.adminRepository.existAdminByUser(user);
    }
    
    @DeleteMapping("/administrateur/{id}")
    void rmAdministrateurById(@PathVariable int id) {
        this.adminRepository.deleteById(id);
    }
}
