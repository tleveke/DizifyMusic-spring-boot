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

import com.ynov.nantes.soap.entity.Album;
import com.ynov.nantes.soap.entity.Artist;
import com.ynov.nantes.soap.entity.Favoris;
import com.ynov.nantes.soap.entity.Title;
import com.ynov.nantes.soap.entity.User;
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
    @GetMapping("/favoris/user/{emailUser}")
    Favoris getFavorisByUser(@PathVariable String emailUser) {
      
        Favoris favoris = this.favorisRepository.findFavorisByUserEmail(emailUser);
        
        if (favoris != null) {
            for (Artist artist : favoris.getArtists()) {
                artist.setFavoris(true);
            }
            for (Album album : favoris.getAlbums()) {
                album.setFavoris(true);
            }
            for (Title title : favoris.getTitles()) {
                title.setFavoris(true);
            }
        }
        
        return favoris;
    }
    
    @PostMapping("/favoris")
    Favoris newFavoris(@RequestBody Favoris favoris) {
      return this.favorisRepository.save(favoris);
    }
    
    @PutMapping("/favoris/title")
    Favoris editFavorisTitle(@RequestBody Favoris favoris) {
        Favoris favTempo = this.getFavorisUserExist(favoris.getUser().getEmail());
        
        if (favTempo != null) {
            for (Title title : favoris.getTitles()) {
                
                if (title.isFavoris()) {
                    //favTempo.getTitles().remove(title);
                    favTempo.setTitles(deleteTitle(favTempo.getTitles(), title));
                }
                else {
                    favTempo.getTitles().add(title);
                }
            }
            favoris = favTempo;
        }

        return this.favorisRepository.save(favoris);
    }
    
    @PutMapping("/favoris/album")
    Favoris editFavorisAlbum(@RequestBody Favoris favoris) {
        Favoris favTempo = this.getFavorisUserExist(favoris.getUser().getEmail());
        
        if (favTempo != null) {
            for (Album album : favoris.getAlbums()) {
                if (album.isFavoris()) {
                    //favTempo.getAlbums().remove(album);
                    favTempo.setAlbums(deleteAlbum(favTempo.getAlbums(), album));
                }
                else {
                    favTempo.getAlbums().add(album);
                }
            }
            favoris = favTempo;
        }

        return this.favorisRepository.save(favoris);
    }
    
    @PutMapping("/favoris/artist")
    Favoris editFavorisArtist(@RequestBody Favoris favoris) {
        Favoris favTempo = this.getFavorisUserExist(favoris.getUser().getEmail());
        
        if (favTempo != null) {
            
            for (Artist artist : favoris.getArtists()) {
                if (artist.isFavoris()) {
                    favTempo.setArtists(deleteArtist(favTempo.getArtists(), artist));
                }
                else {
                    favTempo.getArtists().add(artist);
                }
            }
            favoris = favTempo;
            
        }

        return this.favorisRepository.save(favoris);
    }
    
    @DeleteMapping("/favoris/{id}")
    void rmFavorisById(@PathVariable int id) {
        this.favorisRepository.deleteById(id);
    }
    
    
    Favoris getFavorisUserExist(String email) {
        return this.favorisRepository.findFavorisByUserEmail(email);
    }
    
    Set<Artist> deleteArtist(Set<Artist> favTempo,Artist artist) {
        for (Artist artistE : favTempo) {
            if (artist.getId() == artistE.getId()) {
                favTempo.remove(artistE);
                break;
            }
        }
        return favTempo;
    }
    Set<Album> deleteAlbum(Set<Album> favTempo,Album artist) {
        for (Album artistE : favTempo) {
            if (artist.getId() == artistE.getId()) {
                favTempo.remove(artistE);
                break;
            }
        }
        return favTempo;
    }
    Set<Title> deleteTitle(Set<Title> favTempo,Title artist) {
        for (Title artistE : favTempo) {
            if (artist.getId() == artistE.getId()) {
                favTempo.remove(artistE);
                break;
            }
        }
        return favTempo;
    }
}
