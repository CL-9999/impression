package com.itbear.impression.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "contactController")
public class ContactController {

    @GetMapping(path = "/contact")
    public String contact() {

        return "contact";
    }
}
