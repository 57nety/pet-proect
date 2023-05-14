package com.pet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pet.entities.Favorites;

@Repository
public interface FavoritesRepository extends CrudRepository<Favorites, Integer> {
}
