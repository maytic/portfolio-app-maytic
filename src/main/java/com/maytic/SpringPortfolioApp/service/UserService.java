package com.maytic.SpringPortfolioApp.service;

import com.maytic.SpringPortfolioApp.entity.Manga;
import com.maytic.SpringPortfolioApp.entity.User;

public interface UserService {
    public User getUserById(int id);
    public void createUser(User user);
    public User getUserByName(String username);

    public void createManga(Manga manga);
    public Manga getMangaById(int id);

    public void addMangaToUser(User user);
}
