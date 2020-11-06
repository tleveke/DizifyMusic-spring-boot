package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Album;
import com.ynov.nantes.soap.repository.AlbumRepository;

@RestController
public class AlbumController {
    
    private AlbumRepository albumRepository;


    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }
    
    @GetMapping("/albums")
    List<Album> getAlbums() {
      return this.albumRepository.findAll();
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
    
    @DeleteMapping("/album/{id}")
    void rmAlbumById(@PathVariable int id) {
        this.albumRepository.deleteById(id);
    }
}
