package com.maytic.SpringPortfolioApp.DAO;


import com.maytic.SpringPortfolioApp.entity.Manga;
import com.maytic.SpringPortfolioApp.entity.User;

public interface HerokuRepository {
    public void createUser(User user);
    public User getUserById(int id);
    public User getUserByName(String username);

    public void createManga(Manga manga);
    public Manga getMangaById(int id);

    public void addMangaToUser(User user);

}
