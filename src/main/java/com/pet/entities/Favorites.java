package com.pet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "book_id", nullable = false)
    private Integer bookId;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "book_link", nullable = false)
    private String bookLink;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Favorites() {}

    public Favorites(Integer booId, String bookTitle, String bookLink){
        this.bookId = booId;
        this.bookTitle = bookTitle;
        this.bookLink = bookLink;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookLink() {
        return bookLink;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "\nFavorites{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookLink='" + bookLink + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorites favorites = (Favorites) o;
        return Objects.equals(id, favorites.id) && Objects.equals(bookId, favorites.bookId) && Objects.equals(bookTitle, favorites.bookTitle) && Objects.equals(bookLink, favorites.bookLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, bookTitle, bookLink);
    }
}
