package com.ynov.nantes.soap.entity;

import java.util.List;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

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
    
    @JsonInclude()
    @Transient
    private int dureeTotale;
    
    @JsonInclude()
    @Transient
    private List<Title> listTitles;
    
    @JsonInclude()
    @Transient
    private boolean favoris = false;

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

    public int getDureeTotale() {
        return dureeTotale;
    }

    public void setDureeTotale(int dureeTotale) {
        this.dureeTotale = dureeTotale;
    }

    public boolean isFavoris() {
        return favoris;
    }

    public void setFavoris(boolean favoris) {
        this.favoris = favoris;
    }

    public List<Title> getListTitles() {
        return listTitles;
    }

    public void setListTitles(List<Title> listTitles) {
        this.listTitles = listTitles;
    }

    
}
