package com.ynov.nantes.soap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.Assert;

import com.ynov.nantes.soap.entity.Album;
import com.ynov.nantes.soap.entity.Title;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2020-10
 * @version 1.0
 */
public interface AlbumRepository extends JpaRepository<Album, Integer> {

   /// TODO les méthodes pertinents en plus des méthodes CRUD (autogénérées), type findByName

    Album findAlbumById(int id);
    Album findAlbumByEntitled(String entitled);
    List<Album> findAlbumsByArtistId(int id);
}