package com.ynov.nantes.soap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.Assert;

import com.ynov.nantes.soap.entity.Playlist;
import com.ynov.nantes.soap.entity.Title;
import com.ynov.nantes.soap.entity.User;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2020-10
 * @version 1.0
 */
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

    /// TODO les méthodes pertinents en plus des méthodes CRUD (autogénérées), type findByName

    Playlist findPlaylistById(int id);

    List<Playlist> findPlaylistsByUserEmail(String email);

}