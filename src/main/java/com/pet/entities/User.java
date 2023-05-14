package com.pet.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "user_")
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StorySearch> listStorySearch = new HashSet<>();

    public void addStorySearch(StorySearch storySearch){
        listStorySearch.add(storySearch);
        storySearch.setUser(this);
    }

    public void removeStorySearch(StorySearch storySearch){
        listStorySearch.remove(storySearch);
        storySearch.setUser(null);
    }

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StoryDownload> listStoryDownload = new HashSet<>();

    public void addStoryDownload(StoryDownload storyDownload){
        listStoryDownload.add(storyDownload);
        storyDownload.setUser(this);
    }

    public void removeStoryDownload(StoryDownload storyDownload){
        listStoryDownload.remove(storyDownload);
        storyDownload.setUser(null);
    }

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Favorites> listFavorites = new HashSet<>();

    public void addFavorites(Favorites favorites){
        listFavorites.add(favorites);
        favorites.setUser(this);
    }

    public void removeFavorites(Favorites favorites){
        listFavorites.remove(favorites);
        favorites.setUser(null);
    }
}