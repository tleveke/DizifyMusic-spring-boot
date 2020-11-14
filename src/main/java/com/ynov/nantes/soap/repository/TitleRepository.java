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
public interface TitleRepository extends JpaRepository<Title, Integer> {

   /// TODO les méthodes pertinents en plus des méthodes CRUD (autogénérées), type findByName

    Title findTitleById(int id);
    Title findTitleByDesignation(String designation);
    List<Title> findTitleByAlbumId(int id);
}