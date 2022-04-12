package com.springconfig.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Value("${city.name}")
    private String city;
    @Autowired
    private Environment env;

    @Autowired
    private ConfigPropertiesController config;



    @GetMapping
    public String getCity() {
        System.out.println("spring is running!");

        return "spring is running" + config;
    }
}
