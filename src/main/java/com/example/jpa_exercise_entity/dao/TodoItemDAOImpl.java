package com.example.jpa_exercise_entity.dao;

import com.example.jpa_exercise_entity.model.TodoItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class TodoItemDAOImpl implements TodoItemDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<TodoItem> findById(String todoId) {
        return Optional.empty();
    }

    @Override
    public TodoItem save(TodoItem todoItem) {
        return null;
    }

    @Override
    public TodoItem update(TodoItem todoItem) {
        return null;
    }

    @Override
    public TodoItem delete(TodoItem todoItem) {
        return null;
    }
}
