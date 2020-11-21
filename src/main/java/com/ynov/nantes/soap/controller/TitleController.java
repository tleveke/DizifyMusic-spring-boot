package com.ynov.nantes.soap.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    
    @GetMapping("/titles/accueil")
    List<Title> getTitlesAccueil() {
      
        List<Title>  titles =  this.titleRepository.findAll();
        List<Title> titles_accueil = new ArrayList<Title>();
        
        Random rand = new Random();
        
        int boucle = 3;
        
        if (boucle > titles.size()) {
            boucle = titles.size();
        }
        
        for (int i = 0; i < boucle ; i++) {
            int random = rand.nextInt(titles.size());
            
            while (titles_accueil.contains(titles.get(random))) {
                random = rand.nextInt(titles.size());
            }
            
            titles_accueil.add(titles.get(random));   
        }
        
        return titles_accueil;
        
        //return this.titleRepository.findAll();
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
