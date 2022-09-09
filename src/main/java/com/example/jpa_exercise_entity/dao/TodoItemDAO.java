package com.example.jpa_exercise_entity.dao;

import com.example.jpa_exercise_entity.model.TodoItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TodoItemDAO {

    Optional<TodoItem> findById (String todoId);
    TodoItem save (TodoItem todoItem);
    List<TodoItem> findByTitle (String title);
    List<TodoItem> findAll();
    List<TodoItem> findByDone();
    List<TodoItem> findByDeadLineBetween(LocalDateTime start, LocalDateTime end);
    List<TodoItem> findByDeadLineBefore(LocalDateTime end);
    List<TodoItem> findByDeadLineAfter(LocalDateTime start);
    TodoItem update (TodoItem todoItem);
    void delete (TodoItem todoItem);


}
