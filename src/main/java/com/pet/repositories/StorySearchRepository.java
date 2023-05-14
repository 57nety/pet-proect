package com.pet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pet.entities.StorySearch;

@Repository
public interface StorySearchRepository extends CrudRepository<StorySearch,Integer> {
}
