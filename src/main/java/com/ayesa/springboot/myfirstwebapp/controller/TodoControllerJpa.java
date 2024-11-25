package com.ayesa.springboot.myfirstwebapp.controller;

import com.ayesa.springboot.myfirstwebapp.model.Todo;
import com.ayesa.springboot.myfirstwebapp.repository.TodoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 25/11/2024 - 08:42
 * @since jdk 1.17
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class TodoControllerJpa {

    private final TodoRepository todoRepository;


    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap model) {

        List<Todo> todos = todoRepository.findByUsername(this.getLoggedInUserName());
        model.put("todos", todos);

        return "listTodos";
    }

    private String getLoggedInUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("/add-todo")
    public String showNewTodoPage(ModelMap model) {
        Todo todo = Todo.builder()
                .id(0)
                .description("")
                .targetDate(LocalDate.now().plusYears(1))
                .done(false)
                .build();

        model.put("todo", todo);

        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(@Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUsername(this.getLoggedInUserName());
        todoRepository.save(todo);

        return "redirect:/list-todos";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);

        return "redirect:/list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        model.put("todo", todo);

        return "todo";
    }

    @PostMapping("/update-todo")
    public String updateTodo(@Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUsername(this.getLoggedInUserName());
        todoRepository.save(todo);

        return "redirect:/list-todos";
    }
}
