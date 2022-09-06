package com.example.jpa_exercise_entity.dao;

import com.example.jpa_exercise_entity.model.TodoItem;

import java.util.Optional;

public interface TodoItemDAO {

    Optional<TodoItem> findById (String todoId);
    TodoItem save (TodoItem todoItem);
    TodoItem update (TodoItem todoItem);
    TodoItem delete (TodoItem todoItem);

}
