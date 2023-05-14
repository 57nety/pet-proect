package com.pet.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Data
@Table("user")
public class User {

    @Id
    private Integer id;

    private String login;

    private List<StorySearch> listStorySearch = new ArrayList<>();

    private List<StoryDownload> listStoryDownload = new ArrayList<>();

    private List<Favorites> listFavorites = new ArrayList<>();

    public void addStorySearch(StorySearch storySearch){
        this.listStorySearch.add(storySearch);
    }

    public void addStoryDownload(StoryDownload storyDownload){
        this.listStoryDownload.add(storyDownload);
    }

    public void addFavorites(Favorites favorites){
        this.listFavorites.add(favorites);
    }
}
