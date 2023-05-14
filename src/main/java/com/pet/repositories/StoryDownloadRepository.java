package com.pet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pet.entities.StoryDownload;

@Repository
public interface StoryDownloadRepository extends CrudRepository<StoryDownload, Integer> {
}
