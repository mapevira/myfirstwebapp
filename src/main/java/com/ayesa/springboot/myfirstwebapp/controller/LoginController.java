package com.ayesa.springboot.myfirstwebapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String goToLoginPage(@RequestParam String name, ModelMap modelMap) {
        log.info("GoToLoginPage() - name: {} (in controller) called!", name);

        modelMap.put("name", name);

        return "login";
    }

}
