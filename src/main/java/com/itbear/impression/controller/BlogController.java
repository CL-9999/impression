package com.itbear.impression.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "blogController")
public class BlogController {

    @GetMapping(path = "/blog")
    public String blog() {

        return "blog";
    }
}
