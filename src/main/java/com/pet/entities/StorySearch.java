package com.pet.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("story_search")
public class StorySearch {

    @Id
    private Integer id;

    private String request;

    private Date date = new Date();
}
