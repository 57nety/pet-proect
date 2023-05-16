package com.pet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "story_search")
public class StorySearch {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "request",nullable = false)
    private String request;

    @Column(name = "date",nullable = false)
    private Date date = new Date();

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private StorySearch(){}

    public StorySearch(String request){
        this.request = request;
    }

    public Integer getId() {
        return id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "\nStorySearch{" +
                "id=" + id +
                ", request='" + request + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorySearch that = (StorySearch) o;
        return Objects.equals(id, that.id) && Objects.equals(request, that.request) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, request, date);
    }
}

