package com.ynov.nantes.soap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Playlist;
import com.ynov.nantes.soap.repository.PlaylistRepository;

@RestController
public class PlaylistController {
    
    private PlaylistRepository playlistRepository;


    public PlaylistController(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }
    
    @GetMapping("/playlists")
    List<Playlist> getPlaylists() {
      return this.playlistRepository.findAll();
    }
    

    @GetMapping("/playlist/{id}")
    Playlist getPlaylistById(@PathVariable int id) {
      return this.playlistRepository.findPlaylistById(id);
    }
    
    @PostMapping("/playlist")
    Playlist newPlaylist(@RequestBody Playlist playlist) {
      return this.playlistRepository.save(playlist);
    }
    
    @DeleteMapping("/playlist/{id}")
    void rmPlaylistById(@PathVariable int id) {
        this.playlistRepository.deleteById(id);
    }
}
