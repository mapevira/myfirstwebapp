package com.ayesa.springboot.myfirstwebapp.service;

import org.springframework.stereotype.Service;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 27/10/2024 - 16:16
 * @since jdk 1.17
 */
@Service
public class AuthenticationService {

    public boolean authenticate(String name, String password) {
        return name.equals("admin") && password.equals("admin");
    }

}
