package com.maytic.SpringPortfolioApp.DAO;

import com.maytic.SpringPortfolioApp.entity.Manga;
import com.maytic.SpringPortfolioApp.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * repository connects to database and handles all services associated to database
 */
@Repository
public class HerokuRepositoryImpl implements HerokuRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        // get session
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
    }

    @Override
    public User getUserById(int id) {
        // get session
        Session session = entityManager.unwrap(Session.class);

        User user = session.get(User.class, id);

        // handle user not found exception
        if(user == null){
            throw new UsernameNotFoundException("User not found with id: " + id);
        }

        // return usr
        return user;
    }

    @Override
    public User getUserByName(String username) {
        // get session
        Session session = entityManager.unwrap(Session.class);

        // create query
        Query userQuery = session.createQuery("FROM User WHERE username = :username");
        userQuery.setParameter("username", username);
        User user;

        // catch user not found error from query
        try{
            user = (User) userQuery.getSingleResult();
        }catch (Exception e){
            throw new UsernameNotFoundException(username);
        }

        // return user found
        return user;
    }

    @Override
    public void createManga(Manga manga) {
        // get session
        Session session = entityManager.unwrap(Session.class);

        // save manga
        session.save(manga);
    }

    @Override
    public Manga getMangaById(int id) {
        // get session
        Session session = entityManager.unwrap(Session.class);

        // retrun manga by id
        return session.get(Manga.class, id);
    }


    @Override
    public void addMangaToUser(User user) {
        // get session
        Session session = entityManager.unwrap(Session.class);

        // update manga in user
        session.update(user);
    }
}
