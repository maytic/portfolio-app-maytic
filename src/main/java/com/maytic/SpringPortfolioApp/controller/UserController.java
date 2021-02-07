package com.maytic.SpringPortfolioApp.controller;

import com.maytic.SpringPortfolioApp.entity.Manga;
import com.maytic.SpringPortfolioApp.entity.User;
import com.maytic.SpringPortfolioApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * handle user rest request
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * find user by ud
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    /**
     * create new user and encode their password user
     * @param user
     */
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // encode password
        user.setPassword(encoder.encode(user.getPassword()));

        // create new user
        userService.createUser(user);
    }

    /**
     * create new manga in the database
     * @param manga
     */
    @PostMapping("/manga/create-manga")
    public void createManga(@RequestBody Manga manga) {

        userService.createManga(manga);
    }

    /**
     * get manga by id
     * @param id
     * @return
     */
    @GetMapping("/manga/{id}")
    public Manga getMangaByid(@PathVariable int id) {
        return userService.getMangaById(id);
    }

    /**
     * add new manga to user whose logged in
     * @param principal
     * @param mangaId
     */
    @PostMapping("/manga/add-manga/{mangaId}")
    public void addMangaToUser(@PathVariable int mangaId, Principal principal) {

        User user = userService.getUserByName(principal.getName());
        Manga manga = userService.getMangaById(mangaId);
        user.addManga(manga);
        if (manga == null) {
            throw new RuntimeException();
        }

        userService.addMangaToUser(user);

    }
}

