package com.ayesa.springboot.myfirstwebapp.controller;

import com.ayesa.springboot.myfirstwebapp.model.Todo;
import com.ayesa.springboot.myfirstwebapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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

}
