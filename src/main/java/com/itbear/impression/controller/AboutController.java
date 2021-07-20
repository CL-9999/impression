package com.itbear.impression.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "aboutController")
public class AboutController {

    @GetMapping(path = "/about")
    public String about() {

        return "about";
    }
}
