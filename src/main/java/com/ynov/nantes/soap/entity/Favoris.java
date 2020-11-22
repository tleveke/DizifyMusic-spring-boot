package com.ynov.nantes.soap.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entité Auteur persistente en base de données.
 * 
 * @author Matthieu BACHELIER
 * @since 2020-10
 * @version 1.0
 */
@Entity
@Table(name = "favoris")

public class Favoris {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_user")
    private User user;
    
    @ManyToMany
    @JoinTable( name = "T_Favoris_Title",
    joinColumns = @JoinColumn( name = "idFavoris" ),
    inverseJoinColumns = @JoinColumn( name = "idTitle" ) )
    private Set<Title> titles;
    
    @ManyToMany
    @JoinTable( name = "T_Favoris_Album",
    joinColumns = @JoinColumn( name = "idFavoris" ),
    inverseJoinColumns = @JoinColumn( name = "idAlbum" ) )
    private Set<Album> albums;
    
    @ManyToMany
    @JoinTable( name = "T_Favoris_Artist",
    joinColumns = @JoinColumn( name = "idFavoris" ),
    inverseJoinColumns = @JoinColumn( name = "idArtist" ) )
    private Set<Artist> artists;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Title> getTitles() {
        return titles;
    }

    public void setTitles(Set<Title> titles) {
        this.titles = titles;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }
    
    

    
}
