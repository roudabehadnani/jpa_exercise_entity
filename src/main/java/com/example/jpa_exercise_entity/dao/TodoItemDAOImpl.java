package com.example.jpa_exercise_entity.dao;

import com.example.jpa_exercise_entity.model.TodoItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoItemDAOImpl implements TodoItemDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<TodoItem> findById(String todoId) {
        if (todoId == null){
            throw  new IllegalArgumentException("Invalid id");
        }
            TodoItem item = entityManager.find(TodoItem.class, todoId);
            return Optional.ofNullable(item);
        }

    @Transactional
    @Override
    public TodoItem save(TodoItem todoItem) {
        if (todoItem == null) throw new IllegalArgumentException("todoItem was null");
        entityManager.persist(todoItem);
        return todoItem;
    }

    @Override
    @Transactional
    public List<TodoItem> findByTitle(String title){
        if (title == null){
            throw new IllegalArgumentException("title: " + null);
        }
        Query query = entityManager.createQuery("SELECT s FROM TodoItem s WHERE s.title = ?1");
        query.setParameter(1, title);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<TodoItem> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM TodoItem s");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<TodoItem> findByDone() {
        Query query = entityManager.createQuery("SELECT s FROM TodoItem s WHERE s.done = true ");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<TodoItem> findByDeadLineBetween(LocalDateTime start, LocalDateTime end) {
        Query query = entityManager.createQuery("SELECT s FROM TodoItem s WHERE s.deadline BETWEEN ?1 AND ?2");
        query.setParameter(1,start);
        query.setParameter(2,end);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<TodoItem> findByDeadLineBefore(LocalDateTime end) {
        Query query = entityManager.createQuery("SELECT s FROM TodoItem s WHERE s.deadline < ?1");
        query.setParameter(1,end);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<TodoItem> findByDeadLineAfter(LocalDateTime start) {
        Query query = entityManager.createQuery("SELECT s FROM TodoItem s WHERE s.deadline > ?1");
        query.setParameter(1,start);
        return query.getResultList();
    }

    @Transactional
    @Override
    public TodoItem update(TodoItem todoItem) {
        return entityManager.merge(todoItem);
    }

    @Transactional
    @Override
    public void delete(TodoItem todoItem) {
        entityManager.remove(todoItem);
    }
}
