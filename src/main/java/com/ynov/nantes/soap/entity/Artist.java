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
import javax.persistence.Table;

/**
 * Entité Auteur persistente en base de données.
 * 
 * @author Matthieu BACHELIER
 * @since 2020-10
 * @version 1.0
 */
@Entity
@Table(name = "artist")

public class Artist {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column (name = "alias")
    private String alias;
    
    @Column (name = "avatar")
    private String avatar;
   
    @ManyToMany
    @JoinTable( name = "T_Favoris_Artist",
    joinColumns = @JoinColumn( name = "idArtist" ),
    inverseJoinColumns = @JoinColumn( name = "idFavoris" ) )
    private Set<Favoris> listArtistsFav;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Set<Favoris> getListArtistsFav() {
        return listArtistsFav;
    }

    public void setListArtistsFav(Set<Favoris> listArtistsFav) {
        this.listArtistsFav = listArtistsFav;
    }
    
}
