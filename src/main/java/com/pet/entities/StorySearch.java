package com.pet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;
import java.util.Objects;

@Data
@Table(name = "story_search")
@Entity
public class StorySearch {

    @Id
    @Column(name = "story_search_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "request",nullable = false)
    private String request;

    @Column(name = "date",nullable = false)
    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        StorySearch storySearch = (StorySearch) o;
        return this.id == storySearch.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
