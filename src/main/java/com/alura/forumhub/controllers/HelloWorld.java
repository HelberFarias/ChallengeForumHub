package com.alura.forumhub.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/opa")
public class HelloWorld {

    @GetMapping
    public String helloWord() {
        return "Opa mundao!";
    }
}
