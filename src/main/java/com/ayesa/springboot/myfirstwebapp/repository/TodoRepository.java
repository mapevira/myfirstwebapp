package com.ayesa.springboot.myfirstwebapp.repository;

import com.ayesa.springboot.myfirstwebapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - raulp
 * @version 25/11/2024 - 08:40
 * @since jdk 1.21
 */
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByUsername(String username);

}
