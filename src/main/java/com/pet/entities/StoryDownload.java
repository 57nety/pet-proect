package com.pet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
@Table(name = "story_download")
@Entity
public class StoryDownload {

    @Id
    @Column(name = "story_download_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_link")
    private String bookLink;

    @Column(name = "date")
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
        StoryDownload storyDownload = (StoryDownload) o;
        return this.id == storyDownload.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
