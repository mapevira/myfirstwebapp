package com.ayesa.springboot.myfirstwebapp.controller;

import com.ayesa.springboot.myfirstwebapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 27/10/2024 - 10:10
 * @since jdk 1.17
 */
@Controller
@RequiredArgsConstructor
@SessionAttributes("name")
@Slf4j
public class LoginController {

    private final AuthenticationService authenticationService;

    @GetMapping("/login")
    public String goToLoginPage() {
        log.info("GoToLoginPage() (in controller) called!");

        return "login";
    }

    @PostMapping("/login")
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        log.info("GoToWelcomePage() (in controller) called!");

        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);

            return "welcome";
        }

        model.put("errorMessage", "Invalid Credentials! Please try again.");

        return "login";
    }
}
