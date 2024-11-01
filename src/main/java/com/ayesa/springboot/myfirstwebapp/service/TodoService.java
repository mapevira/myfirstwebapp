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

    static {
        todos = new ArrayList<>();
        todos.add(Todo.builder()
                .id(1)
                .username("in28minutes")
                .description("Learn AWS")
                .targetDate(LocalDate.now().plusYears(1))
                .done(false)
                .build());

        todos.add(Todo.builder()
                .id(2)
                .username("in28minutes")
                .description("Learn DevOps")
                .targetDate(LocalDate.now().plusYears(2))
                .done(false)
                .build());

        todos.add(Todo.builder()
                .id(3)
                .username("in28minutes")
                .description("Learn Full Stack Development")
                .targetDate(LocalDate.now().plusYears(3))
                .done(false)
                .build());
    }

    public List<Todo> retrieveTodos(String username) {
        List<Todo> filteredTodos = new ArrayList<>();

        todos.stream().filter(todo -> todo.getUsername().equals(username))
                .forEach(filteredTodos::add);

        return filteredTodos;
    }
    
}
