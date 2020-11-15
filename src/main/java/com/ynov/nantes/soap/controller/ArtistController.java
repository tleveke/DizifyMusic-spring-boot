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
import com.ynov.nantes.soap.repository.ArtistRepository;
import com.ynov.nantes.soap.repository.FavorisRepository;

@RestController
public class ArtistController {
    
    private ArtistRepository artistRepository;
    private FavorisRepository favorisRepository;


    public ArtistController(ArtistRepository artistRepository,FavorisRepository favorisRepository) {
        this.artistRepository = artistRepository;
        this.favorisRepository = favorisRepository;
    }
    
    @GetMapping("/artists")
    List<Artist> getArtists() {
      return this.artistRepository.findAll();
    }
    
    @GetMapping("/artists/{emailUser}")
    List<Artist> getAlbumsUser(@PathVariable String emailUser) {
        
        List<Artist> artists =  this.artistRepository.findAll();
        Favoris favoris = this.favorisRepository.findFavorisByUserEmail(emailUser);
        
        for (Artist favori : favoris.getArtists()) {
            for (Artist artist : artists) {
                if (artist == favori) {
                    artist.setFavoris(true);
                }
            }
        }
        
        return artists;
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
        System.out.println(auhtor.getId());
        System.out.println(auhtor.getAlias());
        System.out.println(auhtor.getAvatar());
        System.out.println(auhtor.getAnnee());
      return this.artistRepository.save(auhtor);
    }
    
    @DeleteMapping("/artist/{id}")
    void rmArtistById(@PathVariable int id) {
        this.artistRepository.deleteById(id);
    }
}
