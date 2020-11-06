package com.ynov.nantes.soap.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "title")

public class Title {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column (name = "designation")
    private String designation;
    
    @Column (name = "duree")
    private int duree;
    
    @Column (name = "image")
    private String image;

    @OneToOne
    @JoinColumn(name = "id_artist")
    private Artist artist;
    
    @OneToOne
    @JoinColumn(name = "id_album")
    private Album album;
    
    @ManyToMany
    @JoinTable( name = "T_Playlist_Title",
    joinColumns = @JoinColumn( name = "idTitle" ),
    inverseJoinColumns = @JoinColumn( name = "idPlaylist" ) )
    private Set<Playlist> listTitles;
    
    @ManyToMany
    @JoinTable( name = "T_Favoris_Title",
    joinColumns = @JoinColumn( name = "idTitle" ),
    inverseJoinColumns = @JoinColumn( name = "idFavoris" ) )
    private Set<Favoris> listTitlesFav;
    
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Set<Favoris> getListTitlesFav() {
        return listTitlesFav;
    }

    public void setListTitlesFav(Set<Favoris> listTitlesFav) {
        this.listTitlesFav = listTitlesFav;
    }
    
}
