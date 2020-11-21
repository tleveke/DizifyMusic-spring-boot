package com.ynov.nantes.soap.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.entity.Artist;
import com.ynov.nantes.soap.entity.Favoris;
import com.ynov.nantes.soap.entity.Playlist;
import com.ynov.nantes.soap.entity.Title;
import com.ynov.nantes.soap.repository.FavorisRepository;
import com.ynov.nantes.soap.repository.PlaylistRepository;

@RestController
public class PlaylistController {

    private PlaylistRepository playlistRepository;
    private FavorisRepository favorisRepository;

    private List<Playlist> gl_playlist;
    private Favoris gl_favoris;

    public PlaylistController(PlaylistRepository playlistRepository, FavorisRepository favorisRepository) {
        this.playlistRepository = playlistRepository;
        this.favorisRepository = favorisRepository;
    }

    @GetMapping("/playlists")
    List<Playlist> getPlaylists() {
        return this.playlistRepository.findAll();
    }

    @GetMapping("/playlists/user/{emailUser}")
    List<Playlist> getPlaylistsUser(@PathVariable String emailUser) {

        gl_playlist = this.playlistRepository.findPlaylistsByUserEmail(emailUser);
        gl_favoris = this.favorisRepository.findFavorisByUserEmail(emailUser);
        for (Playlist pl : gl_playlist) {
            if (pl != null) {
                for (Title playTitle : pl.getTitles()) {
                    for (Title favTitle : gl_favoris.getTitles()) {
                        if (playTitle == favTitle) {
                            playTitle.setFavoris(true);
                        }
                    }
                }
            }
        }

        return gl_playlist;
    }

    @GetMapping("/playlist/{id}")
    Playlist getPlaylistById(@PathVariable int id) {

        Playlist playlist = this.playlistRepository.findPlaylistById(id);
        gl_favoris = this.favorisRepository.findFavorisByUserEmail(playlist.getUser().getEmail());

        if (playlist != null) {
            for (Title playTitle : playlist.getTitles()) {
                for (Title favTitle : gl_favoris.getTitles()) {
                    if (playTitle == favTitle) {
                        playTitle.setFavoris(true);
                    }
                }
            }
        }

        return this.playlistRepository.findPlaylistById(id);
    }

    @PostMapping("/playlist")
    Playlist newPlaylist(@RequestBody Playlist playlist) {
        return this.playlistRepository.save(playlist);
    }

    @PutMapping("/playlist")
    Playlist editPlaylist(@RequestBody Playlist playlist) {
        return this.playlistRepository.save(playlist);
    }

    @PutMapping("/playlist/title")
    List<Playlist> addRemovePlaylistTitle(@RequestBody List<Playlist> playlists) {

        for (Playlist playlist : playlists) {
            
            System.out.println(playlist.getId());
            
            Playlist playTempo = this.playlistRepository.findPlaylistById(playlist.getId());

            for (Title title : playlist.getTitles()) {
                playTempo.getTitles().add(title);
                System.out.println(title.getDesignation());
            }

            this.playlistRepository.save(playTempo);
        }

        return playlists;

        // return this.playlistRepository.save(playlist);
    }

    @PutMapping("/playlist/title/delete")
    Playlist rmPlaylistTitle(@RequestBody Playlist playlist) {
        
        Playlist playTempo = this.playlistRepository.findPlaylistById(playlist.getId());

        playTempo.setTitles( deleteTitle (playTempo.getTitles(),playlist.getTitles() ));
        
        return this.playlistRepository.save(playTempo);
        //this.playlistRepository.deleteByIdAndUser(playlist.getId(),playlist.getUser());
    }

    @DeleteMapping("/playlist/{id}")
    void rmPlaylistById(@PathVariable int id) {
        this.playlistRepository.deleteById(id);
    }

    Set<Title> deleteTitle(Set<Title> favTempo, Set<Title> titles) {
        for (Title artist : titles) {
            for (Title artistE : favTempo) {
                if (artist.getId() == artistE.getId()) {
                    favTempo.remove(artistE);
                    break;
                }
            }
        }
        return favTempo;
    }

}
