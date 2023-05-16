package com.pet.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_account")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "login", nullable = false)
    private String login;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StorySearch> storySearches = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StoryDownload> storyDownloads = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Favorites> favorites = new HashSet<>();

    private User() {}

    public User(String login){
        this.login = login;
    }

    public void addStorySearch(StorySearch storySearch) {
        storySearch.setUser(this);
        this.storySearches.add(storySearch);
    }

    public void removeStorySearch(StorySearch storySearch) {
        storySearch.setUser(null);
        this.storySearches.remove(storySearch);
    }

    public void addStoryDownload(StoryDownload storyDownload) {
        storyDownload.setUser(this);
        this.storyDownloads.add(storyDownload);
    }

    public void removeStoryDownload(StoryDownload storyDownload) {
        storyDownload.setUser(null);
        this.storyDownloads.remove(storyDownload);
    }

    public void addFavorites(Favorites favorites) {
        favorites.setUser(this);
        this.favorites.add(favorites);
    }

    public void removeFavorites(Favorites favorites) {
        favorites.setUser(null);
        this.favorites.remove(favorites);
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<StorySearch> getStorySearches() {
        return storySearches;
    }

    public void setStorySearches(Set<StorySearch> storySearches) {
        if (storySearches == null)
            return;
        storySearches.forEach(storySearch -> storySearch.setUser(this));
        this.storySearches = storySearches;
    }

    public Set<StoryDownload> getStoryDownloads() {
        return storyDownloads;
    }

    public void setStoryDownloads(Set<StoryDownload> storyDownloads) {
        if (storyDownloads == null)
            return;
        storyDownloads.forEach(storySearch -> storySearch.setUser(this));
        this.storyDownloads = storyDownloads;
    }

    public Set<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorites> favorites) {
        if (favorites == null)
            return;
        favorites.forEach(storySearch -> storySearch.setUser(this));
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", storySearches=" + storySearches +
                ", storyDownloads=" + storyDownloads +
                ", favorites=" + favorites +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login);
    }
}
