package com.pet.entities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("favorites")
public class Favorites {

    @Id
    private Integer id;

    @Column("book_id")
    private Integer bookId;

    @Column("book_title")
    private String bookTitle;

    @Column("book_link")
    private String bookLink;
}
