package com.ynov.nantes.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.Assert;

import com.ynov.nantes.soap.entity.Favoris;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2020-10
 * @version 1.0
 */
public interface FavorisRepository extends JpaRepository<Favoris, Integer> {

   /// TODO les méthodes pertinents en plus des méthodes CRUD (autogénérées), type findByName

    Favoris findFavorisById(int id);
}