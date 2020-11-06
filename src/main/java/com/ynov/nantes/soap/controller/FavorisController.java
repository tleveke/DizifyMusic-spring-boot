package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Favoris;
import com.ynov.nantes.soap.repository.FavorisRepository;

@RestController
public class FavorisController {
    
    private FavorisRepository favorisRepository;


    public FavorisController(FavorisRepository favorisRepository) {
        this.favorisRepository = favorisRepository;
    }
    
    @GetMapping("/favorisAll")
    List<Favoris> getFavorisAll() {
      return this.favorisRepository.findAll();
    }
    

    @GetMapping("/favoris/{id}")
    Favoris getFavorisById(@PathVariable int id) {
      return this.favorisRepository.findFavorisById(id);
    }
    
    @PostMapping("/favoris")
    Favoris newFavoris(@RequestBody Favoris favoris) {
      return this.favorisRepository.save(favoris);
    }
    
    @DeleteMapping("/favoris/{id}")
    void rmFavorisById(@PathVariable int id) {
        this.favorisRepository.deleteById(id);
    }
}
