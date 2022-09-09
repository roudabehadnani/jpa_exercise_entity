package com.example.jpa_exercise_entity;

import com.example.jpa_exercise_entity.dao.AppUserDAO;
import com.example.jpa_exercise_entity.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    public MyCommandLineRunner(AppUserDAO appUserDAO, EntityManager entityManager) {
        this.appUserDAO = appUserDAO;
        this.entityManager = entityManager;
    }

    private final AppUserDAO appUserDAO;
    private final EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception{

        AppUser roudabeh = new AppUser("rodi",
                "Roudabeh",
                "Adnani",
                LocalDate.parse("1989-05-01"),
                "pass");

        roudabeh = appUserDAO.save(roudabeh);
        System.out.println(appUserDAO.findById(1));






    }
}
