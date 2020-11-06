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
@Table(name = "album")

public class Album {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column (name = "entitled")
    private String entitled;
    
    @Column (name = "annee")
    private int annee;
    
    @Column (name = "image")
    private String image;
    
    @OneToOne
    @JoinColumn(name = "id_artist")
    private Artist artist;
    
    @ManyToMany
    @JoinTable( name = "T_Favoris_Album",
    joinColumns = @JoinColumn( name = "idAlbum" ),
    inverseJoinColumns = @JoinColumn( name = "idFavoris" ) )
    private Set<Favoris> listAlbumsFav;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Set<Favoris> getListAlbumsFav() {
        return listAlbumsFav;
    }

    public void setListAlbumsFav(Set<Favoris> listAlbumsFav) {
        this.listAlbumsFav = listAlbumsFav;
    }
    
}