package com.maytic.SpringPortfolioApp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * manga table in datbase
 */
@Entity
@Table(name = "manga")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_id")
    private int mangaId;

    @Column(name = "manga_name")
    private String manga_name;

    @Column(name = "manga_genres")
    private String genres;

    @ManyToMany(mappedBy = "mangas")
    private List<User> users;

    // no arg constructor
    public Manga(){}

    // getters and setters
    public int getMangaId() {
        return mangaId;
    }

    public void setMangaId(int mangaId) {
        this.mangaId = mangaId;
    }

    public String getManga_name() {
        return manga_name;
    }

    public void setManga_name(String manga_name) {
        this.manga_name = manga_name;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    // to string


    @Override
    public String toString() {
        return "Manga{" +
                "mangaId=" + mangaId +
                ", manga_name='" + manga_name + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
