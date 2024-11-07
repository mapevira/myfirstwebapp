package com.ayesa.springboot.myfirstwebapp.controller;

import com.ayesa.springboot.myfirstwebapp.model.Todo;
import com.ayesa.springboot.myfirstwebapp.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 01/11/2024 - 10:53
 * @since jdk 1.17
 */
@Controller
@RequiredArgsConstructor
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap model) {

        List<Todo> todos = todoService.retrieveTodos("in28minutes");

        model.put("todos", todos);

        return "listTodos";
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
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todoService.addNewTodo((String) model.get("name"),
                todo.getDescription(),
                LocalDate.now().plusYears(1),
                false);

        return "redirect:/list-todos";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodoById(id);

        return "redirect:/list-todos";
    }
}
