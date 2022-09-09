package com.example.jpa_exercise_entity;

import com.example.jpa_exercise_entity.dao.AppUserDAO;
import com.example.jpa_exercise_entity.dao.TodoItemDAO;
import com.example.jpa_exercise_entity.model.AppUser;
import com.example.jpa_exercise_entity.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Transactional
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    public MyCommandLineRunner(AppUserDAO appUserDAO, TodoItemDAO todoItemDAO, EntityManager entityManager) {
        this.appUserDAO = appUserDAO;
        this.todoItemDAO = todoItemDAO;
        this.entityManager = entityManager;
    }

    private final AppUserDAO appUserDAO;
    private final TodoItemDAO todoItemDAO;
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

        TodoItem item = new TodoItem("Monthly Report",
                "Sending report for the arbetsformedlingen",
                LocalDateTime.parse("2022-10-14T00:00"));

        TodoItem item1 = new TodoItem("Painting",
                "paint two walls and a door",
                LocalDateTime.parse("2022-11-01T16:00"));

        item = todoItemDAO.save(item);
        item1 = todoItemDAO.save(item1);

        System.out.println(todoItemDAO.findAll());
        System.out.println(todoItemDAO.findByDeadLineBefore(LocalDateTime.parse("2022-10-29T23:00")));
        System.out.println(todoItemDAO.findByTitle("painting"));
        System.out.println(todoItemDAO.findByDone());






    }
}
