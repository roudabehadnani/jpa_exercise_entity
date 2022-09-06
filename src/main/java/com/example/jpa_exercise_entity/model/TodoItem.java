package com.example.jpa_exercise_entity.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class TodoItem {

    private String todoId;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private boolean done = false;

    public TodoItem() {
    }

    public TodoItem(String title, String description, LocalDateTime deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return done == todoItem.done && Objects.equals(todoId, todoItem.todoId) && Objects.equals(title, todoItem.title) && Objects.equals(description, todoItem.description) && Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoId, title, description, deadline, done);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "todoId='" + todoId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}';
    }
}
