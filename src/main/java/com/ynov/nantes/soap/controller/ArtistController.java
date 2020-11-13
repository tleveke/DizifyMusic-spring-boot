package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Artist;
import com.ynov.nantes.soap.repository.ArtistRepository;

@RestController
public class ArtistController {
    
    private ArtistRepository artistRepository;


    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    
    @GetMapping("/artists")
    List<Artist> getArtists() {
      return this.artistRepository.findAll();
    }
    
    
    @GetMapping("/artist/{id}")
    Artist getArtistById(@PathVariable int id) {
      return this.artistRepository.findArtistById(id);
    }
    @GetMapping("/artist/{alias}")
    Artist getArtistByAlias(@PathVariable String alias) {
      return this.artistRepository.findArtistByAlias(alias);
    }
    
    @PostMapping("/artist")
    Artist newArtist(@RequestBody Artist auhtor) {
      return this.artistRepository.save(auhtor);
    }
    
    @PutMapping("/artist")
    Artist editArtist(@RequestBody Artist auhtor) {
      return this.artistRepository.save(auhtor);
    }
    
    @DeleteMapping("/artist/{id}")
    void rmArtistById(@PathVariable int id) {
        this.artistRepository.deleteById(id);
    }
}
