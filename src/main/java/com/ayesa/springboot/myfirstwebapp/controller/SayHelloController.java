package com.ayesa.springboot.myfirstwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 26/10/2024 - 19:41
 * @since jdk 1.17
 */
@Controller
public class SayHelloController {

    @GetMapping("/say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @GetMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        return new StringBuilder()
                .append("<html>")
                .append("<head>")
                .append("<title>My First HTML Page</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>Hello World!</h1>")
                .append("<p>This is my first HTML page with body.</p>")
                .append("</body>")
                .append("</html>")
                .toString();

    }
}
