package com.pet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Table(name = "story_download")
public class StoryDownload {

    @Id
    @Column(name = "story_download_id")
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
}
