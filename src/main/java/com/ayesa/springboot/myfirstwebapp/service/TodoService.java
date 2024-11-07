package com.ayesa.springboot.myfirstwebapp.service;

import com.ayesa.springboot.myfirstwebapp.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 27/10/2024 - 17:28
 * @since jdk 1.17
 */
@Service
public class TodoService {

    private static List<Todo> todos;

    private static int todoCount = 0;
    static {
        todos = new ArrayList<>();
        todos.add(Todo.builder()
                .id(++todoCount)
                .username("in28minutes")
                .description("Learn AWS")
                .targetDate(LocalDate.now().plusYears(1))
                .done(false)
                .build());

        todos.add(Todo.builder()
                .id(++todoCount)
                .username("in28minutes")
                .description("Learn DevOps")
                .targetDate(LocalDate.now().plusYears(2))
                .done(false)
                .build());

        todos.add(Todo.builder()
                .id(++todoCount)
                .username("in28minutes")
                .description("Learn Full Stack Development")
                .targetDate(LocalDate.now().plusYears(3))
                .done(false)
                .build());
    }

    public List<Todo> retrieveTodos(final String username) {
        List<Todo> filteredTodos = new ArrayList<>();

        todos.stream().filter(todo -> todo.getUsername().equals(username))
                .forEach(filteredTodos::add);

        return filteredTodos;
    }

    public void addNewTodo(final String username, final String description, final LocalDate targetDate,
                           final boolean done) {

        todos.add(Todo.builder()
                .id(++todoCount)
                .username(username)
                .description(description)
                .targetDate(targetDate)
                .done(done)
                .build());
    }

    public void deleteTodoById(final int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

}
