package com.ayesa.springboot.myfirstwebapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 27/10/2024 - 10:10
 * @since jdk 1.17
 */
@Controller
@Slf4j
public class LoginController {

    @RequestMapping("/login")
    public String goToLoginPage() {
        log.info("GoToLoginPage (in controller) called!");

        return "login";
    }

}
