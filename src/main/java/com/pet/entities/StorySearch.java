package com.pet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Data
@Table(name = "story_search")
public class StorySearch {

    @Id
    @Column(name = "story_search_id")
    private Integer id;

    @Column(name = "request")
    private String request;

    @Column(name = "date")
    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
}
