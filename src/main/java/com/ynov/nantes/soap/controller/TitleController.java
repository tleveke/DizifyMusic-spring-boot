package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Album;
import com.ynov.nantes.soap.entity.Artist;
import com.ynov.nantes.soap.entity.Favoris;
import com.ynov.nantes.soap.entity.Title;
import com.ynov.nantes.soap.repository.FavorisRepository;
import com.ynov.nantes.soap.repository.TitleRepository;

@RestController
public class TitleController {
    
    private TitleRepository titleRepository;
    private FavorisRepository favorisRepository;


    public TitleController(TitleRepository titleRepository,FavorisRepository favorisRepository) {
        this.titleRepository = titleRepository;
        this.favorisRepository = favorisRepository;
    }
    
    @GetMapping("/titles")
    List<Title> getTitles() {
      return this.titleRepository.findAll();
    }
    
    @GetMapping("/titles/{emailUser}")
    List<Title> getTitlesUser(@PathVariable String emailUser) {
        
        List<Title> titles =  this.titleRepository.findAll();
        Favoris favoris = this.favorisRepository.findFavorisByUserEmail(emailUser);
        if (favoris != null) {
          for (Title favori : favoris.getTitles()) {
              for (Title title : titles) {
                  if (title == favori) {
                      title.setFavoris(true);
                  }
              }
          }
        }
        return titles;
    }

    
    @GetMapping("/titles/album/{id}")
    List<Title> getTitleByAlbum(@PathVariable int id) {
      return this.titleRepository.findTitleByAlbumId(id);
    }
    
    @GetMapping("/title/{id}")
    Title getTitleById(@PathVariable int id) {
      return this.titleRepository.findTitleById(id);
    }
    @GetMapping("/title/{designation}")
    Title getTitleByDesignation(@PathVariable String designation) {
      return this.titleRepository.findTitleByDesignation(designation);
    }
    
    @PostMapping("/title")
    Title newTitle(@RequestBody Title title) {
      return this.titleRepository.save(title);
    }
    
    @PutMapping("/title")
    Title editTitle(@RequestBody Title title) {
      return this.titleRepository.save(title);
    }
    
    @DeleteMapping("/title/{id}")
    void rmTitleById(@PathVariable int id) {
        this.titleRepository.deleteById(id);
    }
}
