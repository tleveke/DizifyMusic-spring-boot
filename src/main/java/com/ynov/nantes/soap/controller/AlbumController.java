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
import com.ynov.nantes.soap.entity.Favoris;
import com.ynov.nantes.soap.entity.Title;
import com.ynov.nantes.soap.repository.AlbumRepository;
import com.ynov.nantes.soap.repository.FavorisRepository;
import com.ynov.nantes.soap.repository.TitleRepository;

@RestController
public class AlbumController {
    
    private TitleRepository titleRepository;
    private AlbumRepository albumRepository;
    private FavorisRepository favorisRepository;


    public AlbumController(AlbumRepository albumRepository,TitleRepository titleRepository,FavorisRepository favorisRepository) {
        this.albumRepository = albumRepository;    
        this.titleRepository =  titleRepository;
        this.favorisRepository =  favorisRepository;
    }
    
    @GetMapping("/albums")
    List<Album> getAlbums() {
      
      List<Album> albums = this.albumRepository.findAll();

      for (Album album : albums) {
          album.setDureeTotale(getDureeAlbums(album.getId()));
      }
        
      return albums;
    }
    
    @GetMapping("/albums/{emailUser}")
    List<Album> getAlbumsUser(@PathVariable String emailUser) {
        
        List<Album> albums =  this.albumRepository.findAll();
        Favoris favoris = this.favorisRepository.findFavorisByUserEmail(emailUser);
        
        if (favoris != null) {
          for (Album favori : favoris.getAlbums()) {
              for (Album album : albums) {
                  if (album == favori) {
                      album.setFavoris(true);
                  }
              }
          }
        }     
        return albums;
    }
    
    @GetMapping("/album/{id}")
    Album getAlbumById(@PathVariable int id) {
      return this.albumRepository.findAlbumById(id);
    }
    @GetMapping("/album/{entitled}")
    Album getAlbumByEntitled(@PathVariable String entitled) {
      return this.albumRepository.findAlbumByEntitled(entitled);
    }
    
    @PostMapping("/album")
    Album newAlbum(@RequestBody Album album) {
      return this.albumRepository.save(album);
    }
    
    @PutMapping("/album")
    Album editAlbum(@RequestBody Album album) {
      return this.albumRepository.save(album);
    }
    
    @DeleteMapping("/album/{id}")
    void rmAlbumById(@PathVariable int id) {
        this.albumRepository.deleteById(id);
    }
    
    
    // Fonctions 
    
    int getDureeAlbums(int id) {

        int duree = 0;
        List<Title> titles = this.titleRepository.findTitleByAlbumId(id);
        for (Title title : titles) {
            duree += title.getDuree();
        }
        return duree;
    }
}
