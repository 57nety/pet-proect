package com.pet.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("story_download")
public class StoryDownload {

    @Id
    private Integer id;

    @Column("book_id")
    private Integer bookId;

    @Column("book_link")
    private String bookLink;

    private Date date = new Date();
}
