package com.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pet.entities.StoryDownload;

@Repository
public interface StoryDownloadRepository extends JpaRepository<StoryDownload, Integer> {
}
