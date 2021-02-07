package com.maytic.SpringPortfolioApp.service;

import com.maytic.SpringPortfolioApp.DAO.HerokuRepository;
import com.maytic.SpringPortfolioApp.entity.Manga;
import com.maytic.SpringPortfolioApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * service handels all user services
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    HerokuRepository herokuRepository;

    // get user by id service
    @Override
    @Transactional
    public User getUserById(int id) {
        return herokuRepository.getUserById(id);
    }

    // create new user service
    @Override
    @Transactional
    public void createUser(User user) {
        herokuRepository.createUser(user);
    }

    // get user by name service
    @Override
    public User getUserByName(String username) {
        return herokuRepository.getUserByName(username);
    }

    // create new manga service
    @Override
    @Transactional
    public void createManga(Manga manga) {
        herokuRepository.createManga(manga);
    }

    // get manga by id service

    @Override
    @Transactional
    public Manga getMangaById(int id) {
        return herokuRepository.getMangaById(id);
    }

    // add manga to user service
    @Override
    @Transactional
    public void addMangaToUser(User user) {
        herokuRepository.addMangaToUser(user);
    }
}
