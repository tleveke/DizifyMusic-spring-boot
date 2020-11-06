package com.ynov.nantes.soap.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "playlist")

public class Playlist {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    /*@OneToMany
    @JoinColumn(name = "titles")
    private Set<Title> titles;*/
    
    @ManyToMany
    @JoinTable( name = "T_Playlist_Title",
    joinColumns = @JoinColumn( name = "idPlaylist" ),
    inverseJoinColumns = @JoinColumn( name = "idTitle" ) )
    private Set<Title> listTitles;
    
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
        return listTitles;
    }

    public void setTitles(Set<Title> titles) {
        this.listTitles = titles;
    }
    
}
